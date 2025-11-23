package com.cine.cineme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    public static class ConteudoHome {
        public Long id;
        public String titulo;
        public String textoMock;

        public ConteudoHome(Long id, String titulo, String textoMock) {
            this.id = id;
            this.titulo = titulo;
            this.textoMock = textoMock;
        }
    }
    
    // Simulação das "avaliações recentes"
    private static final List<ConteudoHome> AVALIACOES_RECENTES_MOCK = new ArrayList<>();

    static{
        AVALIACOES_RECENTES_MOCK.add(new ConteudoHome(4L, "Vingança", "Excelente!! Uma trama bem contruída, o protagonista é decidido e sabe o que faz, extremamente calculista, mas por ter algumas cenas extremamente forte, não recomendo para quem não tem estômago pra coisa."));

        AVALIACOES_RECENTES_MOCK.add(new ConteudoHome(6L, "Cães Para a Vida", "Excelente!! Uma trama bem contruída, o protagonista é decidido e sabe o que faz, extremamente calculista, mas por ter algumas cenas extremamente forte, não recomendo para quem não tem estômago pra coisa."));

        AVALIACOES_RECENTES_MOCK.add(new ConteudoHome(5L, "Beleza Oculta", "Excelente!! Uma trama bem contruída, o protagonista é decidido e sabe o que faz, extremamente calculista, mas por ter algumas cenas extremamente forte, não recomendo para quem não tem estômago pra coisa."));
    }

    private static final List<ConteudoHome> RECOMENDACOES_MOCK = new ArrayList<>();
    
    static {
        RECOMENDACOES_MOCK.add(new ConteudoHome(20L, "Seus Olhos", "Comédia Romantica entre deficientes visuais"));
        RECOMENDACOES_MOCK.add(new ConteudoHome(21L, "Pedido de Socorro", "Drama de pessoas que sofreram bullying e começaram uma joranada de luta contra a depressão"));

    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("avaliacoesRecentes", AVALIACOES_RECENTES_MOCK);
        model.addAttribute("recomendacoes", RECOMENDACOES_MOCK);

        return "homepage";
    }

}
