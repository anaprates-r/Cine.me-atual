package com.cine.cineme.service;

import com.cine.cineme.model.Avaliacao;
import com.cine.cineme.model.Conteudo;
import com.cine.cineme.model.Usuario;
import com.cine.cineme.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> listarPorConteudo(String conteudoId) {
        return avaliacaoRepository.findByConteudoId(conteudoId);
    }
    
    public void excluirAvaliacao(String id) {
        avaliacaoRepository.deleteById(id);
    }

    public List<Avaliacao> buscarAvaliacoesPorUsuario(String usuarioId) {
        return avaliacaoRepository.findByUsuarioId(usuarioId);
    }

    public Double calcularMedia(String conteudoId) {
        Double media = avaliacaoRepository.calcularMedia(conteudoId);
        return media != null ? media : 0.0;
    }

    public Avaliacao buscarAvaliacaoDoUsuario(String usuarioId, String conteudoId) {
        return avaliacaoRepository.findByUsuarioIdAndConteudoId(usuarioId, conteudoId);
    }

    public Avaliacao salvar(Usuario usuario, Conteudo conteudo, int nota, String comentario) {

        // Verifica se o usuário já avaliou antes
        Avaliacao existente = avaliacaoRepository.findByUsuarioIdAndConteudoId(usuario.getId(), conteudo.getId());

        if (existente != null) {
            existente.setNota(nota);
            existente.setComentario(comentario);
            return avaliacaoRepository.save(existente); // atualiza
        }

        Avaliacao nova = new Avaliacao();
        nova.setNota(nota);
        nova.setComentario(comentario);
        nova.setUsuario(usuario);
        nova.setConteudo(conteudo);

        return avaliacaoRepository.save(nova);
    }
}
