package br.com.emanueldias.MeuIngresso.dto.ingresso;

import java.math.BigDecimal;

public class IngressoUpdateDTO {
    public String nomeIngresso;
    public Boolean disponivel;
    public BigDecimal valor;

    public IngressoUpdateDTO(Boolean disponivel, String nomeIngresso, BigDecimal valor) {
        this.disponivel = disponivel;
        this.nomeIngresso = nomeIngresso;
        this.valor = valor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
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
