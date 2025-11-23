package com.cine.cineme.repository;

import com.cine.cineme.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, String> {

    List<Avaliacao> findByConteudoId(String conteudoId);

    @Query("SELECT AVG(a.nota) FROM Avaliacao a WHERE a.conteudo.id = :conteudoId")
    Double calcularMedia(String conteudoId);

    Avaliacao findByUsuarioIdAndConteudoId(String usuarioId, String conteudoId);
}
