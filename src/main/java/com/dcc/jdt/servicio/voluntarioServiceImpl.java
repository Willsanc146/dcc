package com.dcc.jdt.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dcc.jdt.entidades.voluntario;
import com.dcc.jdt.repositorio.voluntarioRepository;

@Service
public class voluntarioServiceImpl implements voluntarioService{

    @Autowired
    public voluntarioRepository VoluntarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<voluntario> findAll() {
        return (List<voluntario>) VoluntarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<voluntario> findAll(Pageable pageable){
        return VoluntarioRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(voluntario Voluntario) {
        VoluntarioRepository.save(Voluntario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        VoluntarioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public voluntario findOne(Long id) {
        return VoluntarioRepository.findById(id).orElse(null);
    }

}
