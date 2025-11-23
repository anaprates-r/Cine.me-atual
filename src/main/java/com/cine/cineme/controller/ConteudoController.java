package com.cine.cineme.controller;

import com.cine.cineme.model.Avaliacao;
import com.cine.cineme.model.Conteudo;
import com.cine.cineme.model.Usuario;
import com.cine.cineme.repository.ConteudoRepository;
import com.cine.cineme.repository.UsuarioRepository;
import com.cine.cineme.service.AvaliacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/conteudo")
public class ConteudoController {

    private final ConteudoRepository conteudoRepository;
    private final UsuarioRepository usuarioRepository;
    private final AvaliacaoService avaliacaoService;

    public ConteudoController(ConteudoRepository conteudoRepository,
                              UsuarioRepository usuarioRepository,
                              AvaliacaoService avaliacaoService) {

        this.conteudoRepository = conteudoRepository;
        this.usuarioRepository = usuarioRepository;
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping("/{id}")
    public String detalhes(@PathVariable String id,
                           @RequestParam(required = false) String usuarioId,
                           Model model) {

        Conteudo conteudo = conteudoRepository.findById(id).orElseThrow();

        model.addAttribute("conteudo", conteudo);

        // avaliações totais
        var avaliacoes = avaliacaoService.listarPorConteudo(id);
        model.addAttribute("avaliacoes", avaliacoes);
        model.addAttribute("totalAvaliacoes", avaliacoes.size());

        // média
        model.addAttribute("media", avaliacaoService.calcularMedia(id));

        // avaliação do usuário (caso logado)
        if (usuarioId != null) {
            Avaliacao minha = avaliacaoService.buscarAvaliacaoDoUsuario(usuarioId, id);
            model.addAttribute("minhaAvaliacao", minha);
        }

        return "vizualizacao";
    }
}
