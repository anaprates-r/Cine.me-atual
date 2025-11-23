package com.cine.cineme.controller;

import com.cine.cineme.model.Conteudo;
import com.cine.cineme.service.ConteudoService; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}