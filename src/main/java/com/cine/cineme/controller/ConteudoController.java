package com.cine.cineme.controller;

import com.cine.cineme.model.Conteudo;
import com.cine.cineme.repository.ConteudoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("conteudos")
public class ConteudoController {

    private ConteudoRepository conteudoRepository;

    public ConteudoController(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }

    @PostMapping
    public Conteudo salvar(@RequestBody Conteudo conteudo){
        System.out.println("conteudo: " + conteudo);
        var id = UUID.randomUUID().toString();
        conteudo.setId(id);
        conteudoRepository.save(conteudo);
        return conteudo;
    }
    @GetMapping("{id}")
    public Conteudo obterPorId(@PathVariable("id") String id){
        Optional<Conteudo> conteudo = conteudoRepository.findById(id);
        return conteudo.isPresent() ? conteudo.get() : null;
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        conteudoRepository.deleteById(id);
    }
    @GetMapping("/buscar")
    public List<Conteudo> buscarPorTitulo(@RequestParam String titulo) {
        return conteudoRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Conteudo> exibirPorTipo(@PathVariable("tipo") String tipo){
        return conteudoRepository.findByTipo(tipo);
    }

    @PutMapping("{id}")
    public void editar(@PathVariable("id") String id, @RequestBody Conteudo conteudo){
        conteudo.setId(id);
        conteudoRepository.save(conteudo);
    }
}
