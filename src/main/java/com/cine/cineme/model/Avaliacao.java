package com.cine.cineme.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Avaliacao {
    @Id
    private String id; 
    private int nota;
    private String avaliacao; 
    private LocalDate dataAvaliacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conteudoId") 
    private Conteudo conteudo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioId") 
    private Usuario usuario;

    public Avaliacao() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}