package com.cine.cineme.controller;

import com.cine.cineme.model.Usuario;
import com.cine.cineme.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/perfil/editar")
public class EditarPerfilController {

    private final UsuarioService usuarioService;

    public EditarPerfilController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public String exibirPaginaEdicao(@PathVariable String id, Model model) {

        Usuario usuario = usuarioService.buscarPorId(id);

        model.addAttribute("usuario", usuario);

        return "editaperfil";
    }

    @PostMapping("/{id}/salvar")
    public String salvarEdicao(@PathVariable String id,
                               @RequestParam String campo,
                               @RequestParam String valor) {

        Usuario usuario = usuarioService.buscarPorId(id);

        switch (campo) {
            case "nome" -> usuario.setNome(valor);
            case "nomeUsuario" -> usuario.setNomeUsuario(valor);
            case "senha" -> usuario.setSenha(valor);
        }

        usuarioService.salvar(usuario);

        return "redirect:/perfil/editar/" + id;
    }
}
