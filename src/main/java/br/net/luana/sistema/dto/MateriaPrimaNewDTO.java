package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.domain.tipos.Tipo;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class MateriaPrimaNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String referenciaNaFabrica;

    private String observacoes;
    private Boolean desuso;

    @NotEmpty(message = "Preenchimento obrigatório")
    private Integer UnidadeMedida;

    @NotEmpty(message = "Preenchimento obrigatório")
    private Fornecedor fornecedor;

    public MateriaPrimaNewDTO() {
    }

    public String getReferenciaNaFabrica() {
        return referenciaNaFabrica;
    }

    public void setReferenciaNaFabrica(String referenciaNaFabrica) {
        this.referenciaNaFabrica = referenciaNaFabrica;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean getDesuso() {
        return desuso;
    }

    public void setDesuso(Boolean desuso) {
        this.desuso = desuso;
    }

    public Integer getUnidadeMedida() {
        return UnidadeMedida;
    }

    public void setUnidadeMedida(Integer unidadeMedida) {
        UnidadeMedida = unidadeMedida;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
