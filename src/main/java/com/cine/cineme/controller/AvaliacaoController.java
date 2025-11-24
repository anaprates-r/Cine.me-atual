package com.cine.cineme.controller;

import com.cine.cineme.model.Avaliacao;
import com.cine.cineme.model.Conteudo;
import com.cine.cineme.model.Usuario;
import com.cine.cineme.service.AvaliacaoService;
import com.cine.cineme.service.ConteudoService;
import com.cine.cineme.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/avaliar")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;
    private final ConteudoService conteudoService;
    private final UsuarioService usuarioService;

    public AvaliacaoController(AvaliacaoService avaliacaoService, ConteudoService conteudoService,
                               UsuarioService usuarioService) {
        this.avaliacaoService = avaliacaoService;
        this.conteudoService = conteudoService;
        this.usuarioService = usuarioService;
    }

    // Página de avaliação
    @GetMapping("/{conteudoId}")
    public String novaAvaliacao(@PathVariable String conteudoId, Model model) {
        Conteudo conteudo = conteudoService.buscarPorId(conteudoId);
        model.addAttribute("conteudo", conteudo);

        Usuario usuario = usuarioService.buscarPorId("u1"); //TESTE
        model.addAttribute("usuario", usuario);

        // Se já tiver avaliação, envia para preencher campos
        Avaliacao existente = avaliacaoService.buscarAvaliacaoDoUsuario(usuario.getId(), conteudoId);
        model.addAttribute("avaliacaoExistente", existente);
        if (existente != null && existente.getDataAvaliacao() != null) {
            model.addAttribute("data_avaliacao", existente.getDataAvaliacao());
        } else {
            model.addAttribute("data_avaliacao", java.time.LocalDate.now());
        }

        return "avaliar";
    }

    // Salvar avaliação
    @PostMapping("/salvar")
    public String salvarAvaliacao(
            @RequestParam String conteudoId,
            @RequestParam String usuarioId,
            @RequestParam int nota,
            @RequestParam String comentario){

        Conteudo conteudo = conteudoService.buscarPorId(conteudoId);
        Usuario usuario = usuarioService.buscarPorId("u1");
        avaliacaoService.salvar(usuario, conteudo, nota, comentario);

        // Redireciona para a página do conteúdo depois de salvar
        return "redirect:/conteudo/" + conteudoId;
    }
}
