package com.cine.cineme.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Conteudo {
    @Id
    private String id;
    private String titulo;
    private String descricao;
    private String genero;
    private String duracao;
    private int classificacao;
    private String Url;
    private String tipo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Conteudo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", genero='" + genero + '\'' +
                ", duracao='" + duracao + '\'' +
                ", classificacao=" + classificacao +
                ", Url='" + Url + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
