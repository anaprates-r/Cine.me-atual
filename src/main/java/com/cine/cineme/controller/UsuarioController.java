package com.cine.cineme.controller;

import com.cine.cineme.model.Usuario;
import com.cine.cineme.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        System.out.println("usuario: " + usuario);
        var id = UUID.randomUUID().toString();
        usuario.setId(id);
        usuarioRepository.save(usuario);
        return usuario;
    }

    @PutMapping("{id}")
    public void editar(@PathVariable("id") String id,
                       @RequestBody Usuario usuario) {
        usuario.setId(id);
        usuarioRepository.save(usuario);
    }
}

