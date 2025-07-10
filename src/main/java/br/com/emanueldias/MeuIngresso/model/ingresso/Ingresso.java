package br.com.emanueldias.MeuIngresso.model.ingresso;

import java.math.BigDecimal;

public class Ingresso {
    private Long id;
    private String nomeIngresso;
    private Boolean disponivel;
    private BigDecimal valor;
    private Long eventoId;

    public Ingresso() {
    }

    public Ingresso(Long id, String nomeIngresso, Boolean disponivel, BigDecimal valor, Long eventoId) {
        this.id = id;
        this.nomeIngresso = nomeIngresso;
        this.disponivel = disponivel;
        this.valor = valor;
        this.eventoId = eventoId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeIngresso() {
        return nomeIngresso;
    }

    public void setNomeIngresso(String nomeIngresso) {
        this.nomeIngresso = nomeIngresso;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }
}