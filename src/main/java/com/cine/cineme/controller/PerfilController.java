package com.cine.cineme.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 

import java.util.ArrayList; 
import java.util.List;

@Controller 
public class PerfilController {

    public static class Avaliacao {
        public Long id;
        public String nomeFilme;
        public String textoAvaliacao;
        public double nota;

        public Avaliacao(Long id, String nomeFilme, String textoAvaliacao, double nota) {
            this.id = id;
            this.nomeFilme = nomeFilme;
            this.textoAvaliacao = textoAvaliacao;
            this.nota = nota;
        }
    }

    private static final List<Avaliacao> AVALIACOES_MOCK = new ArrayList<>();
    
    static {
        AVALIACOES_MOCK.add(new Avaliacao(1L, "Roberto Carlos - Rosas Vermelhas", "Filme excelente, final surpreendente! A nota é 5 estrelas porque não tem 6.", 5.0));
        AVALIACOES_MOCK.add(new Avaliacao(2L, "O Grande Gil", "Uma história lenta, mas com um final lógico e estruturado. Recomendo para quem gosta de café.", 3.5));
        AVALIACOES_MOCK.add(new Avaliacao(3L, "A Floresta", "Muito chato, ninguém morre, ninguém se muda, ninguém casa, nada acontece o filme todo. Nota 2,5 só pela trilha sonora.", 2.5));
    }


    @GetMapping("/perfil") 
    public String verPerfil(Model model) {

        model.addAttribute("avaliacoes", AVALIACOES_MOCK);
        
        model.addAttribute("nomeUsuario", "Maria Yasmim"); 
        model.addAttribute("username", "@mariah_dev"); 

        return "perfil";
    }
    
    @GetMapping("/avaliacao/excluir/{id}")
    public String excluirAvaliacao(@PathVariable Long id) {
        
        AVALIACOES_MOCK.removeIf(avaliacao -> avaliacao.id.equals(id));
        
        // teste de sucesso
        System.out.println("✅ Excluído com sucesso o ID: " + id);

        return "redirect:/perfil";
    }
}