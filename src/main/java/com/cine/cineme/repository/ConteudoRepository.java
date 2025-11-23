package com.cine.cineme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cine.cineme.model.Conteudo;

import java.util.List;
import java.util.Optional;

public interface ConteudoRepository extends JpaRepository<Conteudo,String> {
    List<Conteudo> findByTipo(String tipo);
    List<Conteudo> findByTituloContainingIgnoreCase(String titulo);
}
