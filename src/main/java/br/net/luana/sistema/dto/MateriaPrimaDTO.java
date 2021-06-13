package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.materiasprimas.MateriaPrima;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class MateriaPrimaDTO<T extends MateriaPrima, D extends MasterDTOImpl, ID extends Integer>
        extends MasterDTOImpl<T, D, ID>
        implements MasterDTO<T, D, ID>, Serializable {
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

//    @Override
//    public List<D> makeListDTO(List<T> list) {
//        for(T entity : list) {
//
//        }
//        return super.makeListDTO(list);
//    }

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
    
    