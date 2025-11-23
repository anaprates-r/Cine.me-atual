package com.cine.cineme.service;

import com.cine.cineme.model.Avaliacao;
import com.cine.cineme.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> buscarAvaliacoesPorUsuario(String usuarioId) {
        return avaliacaoRepository.findByUsuarioId(usuarioId);
    }
    
    public void excluirAvaliacao(String id) {
        avaliacaoRepository.deleteById(id);
    }
}