package com.cine.cineme.controller; 

import com.cine.cineme.model.Avaliacao; 
import com.cine.cineme.service.AvaliacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import java.util.List;

@Controller 
public class PerfilController {

    private final AvaliacaoService avaliacaoService;
    private static final String ID_USUARIO_LOGADO = "1"; // <<-- ID DE TESTE

    public PerfilController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping("/perfil") 
    public String verPerfil(Model model) {
        
        List<Avaliacao> avaliacoesReais = avaliacaoService.buscarAvaliacoesPorUsuario(ID_USUARIO_LOGADO);

        model.addAttribute("avaliacoes", avaliacoesReais);

        model.addAttribute("nomeUsuario", "ANA CAROLINA"); 
        model.addAttribute("username", "anacarol"); 

        return "perfil";
    }

    @GetMapping("/perfil/editar")
    public String irParaEdicaoPerfil() {
        return "editaperfil";
    }
    
    @GetMapping("/avaliacao/excluir/{id}")
    public String excluirAvaliacao(@PathVariable String id) {
        
        try {
            avaliacaoService.excluirAvaliacao(id);
            System.out.println("✅ Excluído com sucesso o ID: " + id);
        } catch (Exception e) {
            System.err.println("Erro ao excluir avaliação: " + e.getMessage());
        }

        return "redirect:/perfil";
    }
}