package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.Cor;
import br.net.luana.sistema.dto.MasterDTOImpl;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CorDTO <T extends Cor, D extends CorDTO, ID extends Integer>
        extends MasterDTOImpl<T, D, ID>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String referenciaNaFabrica;
    private String nome;
    private String observacoes;
    private Double quantidadeEstoque;


    public CorDTO(){ }

    public CorDTO(T entity) {
        this.id = entity.getId();
        this.referenciaNaFabrica = entity.getReferenciaNaFabrica();
        this.nome = entity.getNome();
        this.observacoes = entity.getObservacoes();
        this.quantidadeEstoque = entity.getQuantidadeEstoque();
    }

    @Override
    public D makeDTO(T entity) {
        return (D) new CorDTO<T, D, ID>(entity);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
