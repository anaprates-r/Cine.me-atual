package com.cine.cineme.model;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int nota;
    private String comentario;
    private LocalDate dataAvaliacao;

    @ManyToOne
    @JoinColumn(name="usuarioId")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="conteudoId")
    private Conteudo conteudo;

    @PrePersist
    public void prePersist() {
        this.dataAvaliacao = LocalDate.now(); // preenche automaticamente a data no banco
    }

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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String avaliacao) {
        this.comentario = avaliacao;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id='" + id + '\'' +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                ", dataAvaliacao=" + dataAvaliacao +
                ", usuario=" + usuario +
                ", conteudo=" + conteudo +
                '}';
    }
}
