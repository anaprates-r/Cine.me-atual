package com.cine.cineme.controller;

import com.cine.cineme.model.Conteudo;
import com.cine.cineme.service.ConteudoService; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List; 


@Controller
public class HomeController {

    private final ConteudoService conteudoService;

    public HomeController(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Conteudo> recomendacoes = conteudoService.getRecomendacoesHome();
        List<Conteudo> avaliacoesRecentes = conteudoService.getAvaliacoesRecentes();

        model.addAttribute("avaliacoesRecentes", avaliacoesRecentes);
        model.addAttribute("recomendacoes", recomendacoes);

        return "homepage";
    }

    @GetMapping("/search")
    public String search(@RequestParam("q") String termo, Model model) {
        // Busca por título (pode ajustar para filmes e séries)
        Conteudo conteudo = conteudoService.buscarPorTitulo(termo);

        if (conteudo != null) {
            // Redireciona para a página de detalhes do conteúdo
            return "redirect:/conteudo/" + conteudo.getId();
        } else {
            model.addAttribute("mensagem", "Nenhum conteúdo encontrado para: " + termo);
            return "homepage"; 
        }
    }
}
