package br.com.emanueldias.MeuIngresso.model.evento;

import java.time.LocalDate;
import java.util.Set;

public class Evento {
    private Long id;
    private String nome;
    private LocalDate data;
    private String descricao;
    private String local;
    private String imagem;
    private Set<String> setores;

    public Evento(){

    }

    public Evento(Long id, String nome, LocalDate data, String descricao, String local, String imagem, Set<String> setores) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.local = local;
        this.imagem = imagem;
        this.setores = setores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Set<String> getSetores() {
        return setores;
    }

    public void setSetores(Set<String> setores) {
        this.setores = setores;
    }
}
