package com.dcc.jdt.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dcc.jdt.entidades.voluntario;

public interface voluntarioRepository extends PagingAndSortingRepository<voluntario, Long> {

    @Transactional(readOnly = true)
    default Page<voluntario> findAll(org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable pageable) {
        return findAll(pageable);
    }
}
