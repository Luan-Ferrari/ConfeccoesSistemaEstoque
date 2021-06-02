package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class MateriaPrimaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Integer id;
    private String referenciaNaFabrica;
    private String observacoes;
    private Boolean desuso;
    @JsonIgnore
    private Integer fornecedorId;
    private String fornecedor;

    public MateriaPrimaDTO() {
    }

    public MateriaPrimaDTO(MateriaPrima obj) {
        this.id = obj.getId();
        this.referenciaNaFabrica = obj.getReferenciaNaFabrica();
        this.observacoes = obj.getObservacoes();
        this.desuso = obj.getDesuso();
        this.fornecedorId = obj.getFornecedor().getId();
        this.fornecedor = obj.getFornecedor().getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Integer fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
