package com.dcc.jdt.servicio;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.dcc.jdt.entidades.voluntario;

public interface voluntarioService {

    public List<voluntario> findAll();

    public Page<voluntario> findAll(Pageable pageable);

    public void save(voluntario Voluntario);

    public voluntario findOne(Long id);

    public void delete(Long id);
}
