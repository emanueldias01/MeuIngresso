package br.com.emanueldias.MeuIngresso.dto.evento;

import java.time.LocalDate;
import java.util.Set;

public class EventoUpdateDTO {
    public String nome;
    public LocalDate data;
    public String descricao;
    public String local;
    public String imagem;
    public Set<String> setores;

    public EventoUpdateDTO(LocalDate data, String descricao, String imagem, String local, String nome, Set<String> setores) {
        this.data = data;
        this.descricao = descricao;
        this.imagem = imagem;
        this.local = local;
        this.nome = nome;
        this.setores = setores;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<String> getSetores() {
        return setores;
    }

    public void setSetores(Set<String> setores) {
        this.setores = setores;
    }
}
