package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import br.net.luana.sistema.dto.MasterDTOImpl;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MateriaPrimaDTO<T extends MateriaPrima, D extends MateriaPrimaDTO, ID extends Integer>
        extends MasterDTOImpl<T, D, ID>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    //@JsonIgnore
    private Integer id;
    private String referenciaNaFabrica;
    private String observacoes;
    private Boolean desuso;
    //@JsonIgnore
    private Integer fornecedorId;
    private String fornecedor;

    public MateriaPrimaDTO() {
    }

    public MateriaPrimaDTO(T entity) {
        this.id = entity.getId();
        this.referenciaNaFabrica = entity.getReferenciaNaFabrica();
        this.observacoes = entity.getObservacoes();
        this.desuso = entity.getDesuso();
        this.fornecedorId = entity.getFornecedor().getId();
        this.fornecedor = entity.getFornecedor().getNome();
    }

    @Override
    public D makeDTO(T entity) {
        return (D)new MateriaPrimaDTO<T, D, ID>(entity);
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
    
    