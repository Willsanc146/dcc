package com.dcc.jdt.controlador;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.dcc.jdt.entidades.voluntario;
import com.dcc.jdt.servicio.voluntarioService;
import com.dcc.jdt.util.paginacion.pageRender;

@Controller
public class voluntarioController {

    @Autowired
    private voluntarioService VoluntarioService;

    @GetMapping("/ver/{id}")
    public String verDetalleDelVoluntario(@PathVariable(value = "id")Long id, Map<String,Object> modelo,RedirectAttributes flash){
        voluntario Voluntario = VoluntarioService.findOne(id);
        if(Voluntario == null){
            flash.addFlashAttribute("error","El voluntario no existe en la base de datos");
            return "redirect:/listar";
        }
        modelo.put("Voluntario", Voluntario);
        modelo.put("titulo","Detalles del Voluntario" + Voluntario.getNombre());
        return "ver";
    }

    @GetMapping({"/","/listar",""})
    public String listarVoluntarios(@RequestParam(name = "page", defaultValue = "0") int page,Model modelo){
        Pageable pageRequest = PageRequest.of(page,4);
        Page<voluntario> Voluntarios = VoluntarioService.findAll(pageRequest);
        pageRender<voluntario> PageRender = new pageRender<>("/listar", Voluntarios);

        modelo.addAttribute("titulo","Listado de voluntarios");
        modelo.addAttribute("Voluntarios",Voluntarios);
        modelo.addAttribute("page",PageRender);
        return "listar";
    }
    @GetMapping("/form")
    public String mostrarFormularioDeRegistrarVoluntario(Map<String,Object>modelo){
        voluntario Voluntario = new voluntario();
        modelo.put("Voluntario", Voluntario);
        modelo.put("titulo","Registro de Voluntarios");
        return "form";
    }

    @PostMapping("/form")
    public String guardarVoluntario(@Valid voluntario Voluntario,BindingResult result,Model modelo,RedirectAttributes flash, SessionStatus status){
        if(result.hasErrors()){
            modelo.addAttribute("titulo", "Registro de Voluntario");
            return "form";
        }
        String mensaje = (Voluntario.getId() !=null) ? "El voluntario ha sido editado con éxito":"Voluntario registrado con éxito";
        VoluntarioService.save(Voluntario);
        status.setComplete();
        flash.addFlashAttribute("success", mensaje);
        return "redirect:/listar";
    }

    @GetMapping("/form/{id}")
    public String editarVoluntario(@PathVariable(value = "id") Long id,Map<String,Object> modelo, RedirectAttributes flash){
        voluntario Voluntario = null;
        if(id>0){
            Voluntario = VoluntarioService.findOne(id);
            if(Voluntario == null){
                flash.addFlashAttribute("error","El ID del empleado no existe en la base de datos");
                return "redirect:/listar";
            }
        }
        else{
            flash.addFlashAttribute("error","El ID del voluntario no puede ser cero");
            return "redirect:/listar";
        }
        modelo.put("Voluntario",Voluntario);
        modelo.put("titulo","Edición de Voluntario");
        return "form";
    }

    @GetMapping("eliminar/{id}")
    public String eliminarVoluntario(@PathVariable(value = "id") Long id,RedirectAttributes flash){
        if(id>0){
            VoluntarioService.delete(id);
            flash.addFlashAttribute("success","Voluntario eliminado con éxito");
        }
        return "redirect:/listar";
    }
}
