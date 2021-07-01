package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.CorEntradas;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class CorEntradasDTO extends MasterDTOImpl<CorEntradas, CorEntradasDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private LocalDate dataEntrada;
    private LocalDate dataFim;
    private Double preco;
    private Double quantidade;
    private Integer corId;
    private String corNome;

    public CorEntradasDTO() {
    }

    public CorEntradasDTO(CorEntradas entity) {
        this.id = entity.getId();
        this.dataEntrada = entity.getDataEntrada();
        this.dataFim = entity.getDataFim();
        this.preco = entity.getPreco();
        this.quantidade = entity.getQuantidade();
        this.corId = entity.getCor().getId();
        this.corNome = entity.getCor().getNome();

    }

    @Override
    public CorEntradasDTO makeDTO(CorEntradas entity) {
        return new CorEntradasDTO(entity);
    }

    @Override
    public CorEntradas makeEntityfromDTO(CorEntradasDTO dto) {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCorId() {
        return corId;
    }

    public void setCorId(Integer corId) {
        this.corId = corId;
    }

    public String getCorNome() {
        return corNome;
    }

    public void setCorNome(String corNome) {
        this.corNome = corNome;
    }
}
