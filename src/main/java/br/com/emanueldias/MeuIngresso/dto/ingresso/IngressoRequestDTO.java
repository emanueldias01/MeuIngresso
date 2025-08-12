package br.com.emanueldias.MeuIngresso.dto.ingresso;

import java.math.BigDecimal;

public class IngressoRequestDTO {
    public String nomeIngresso;
    public Boolean disponivel;
    public BigDecimal valor;
    public Long eventoId;

    public IngressoRequestDTO(Boolean disponivel, Long eventoId, String nomeIngresso, BigDecimal valor) {
        this.disponivel = disponivel;
        this.eventoId = eventoId;
        this.nomeIngresso = nomeIngresso;
        this.valor = valor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public String getNomeIngresso() {
        return nomeIngresso;
    }

    public void setNomeIngresso(String nomeIngresso) {
        this.nomeIngresso = nomeIngresso;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
