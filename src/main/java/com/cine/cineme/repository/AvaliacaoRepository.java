package com.cine.cineme.repository;

import com.cine.cineme.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, String> {
    
    List<Avaliacao> findByUsuarioId(String usuarioId);
}