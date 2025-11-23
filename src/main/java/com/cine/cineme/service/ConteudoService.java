package com.cine.cineme.service;

import com.cine.cineme.model.Conteudo;
import com.cine.cineme.repository.ConteudoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Collections; 
import java.util.Comparator; 

@Service
public class ConteudoService {

    private final ConteudoRepository conteudoRepository;

    public ConteudoService(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }

    // Métodos pra homepage

    // Recomendação usando tipo e limite
    public List<Conteudo> getRecomendacoesHome() {
        List<Conteudo> todosConteudos = conteudoRepository.findAll();
        if (todosConteudos.isEmpty()) {
            return Collections.emptyList();
        }
        return todosConteudos.subList(0, Math.min(todosConteudos.size(), 2));
    }
    
    // Avaliações Recentes, vamos simular com base na Classificação, já que não temos tabela de Avaliação ainda
    public List<Conteudo> getAvaliacoesRecentes() {
        List<Conteudo> todosConteudos = conteudoRepository.findAll();
        if (todosConteudos.isEmpty()) {
            return Collections.emptyList();
        }
        todosConteudos.sort(Comparator.comparing(Conteudo::getClassificacao).reversed());
        return todosConteudos.subList(0, Math.min(todosConteudos.size(), 3));
    }

    // OUTROS MÉTODOS 

    public List<Conteudo> buscarPorTipo(String tipo) {
        return conteudoRepository.findByTipo(tipo);
    }
    
    public Optional<Conteudo> buscarPorId(String id) {
        return conteudoRepository.findById(id);
    }
}