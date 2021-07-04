package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.Cor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CorDTOforCorEntradaDTO extends CorDTO<Cor, CorDTOforCorEntradaDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String referenciaNaFabrica;
    private String nome;


    public CorDTOforCorEntradaDTO(){ }

    public CorDTOforCorEntradaDTO(Cor entity) {
        this.id = entity.getId();
        this.referenciaNaFabrica = entity.getReferenciaNaFabrica();
        this.nome = entity.getNome();
        System.out.println(4);
    }

    @Override
    public CorDTOforCorEntradaDTO makeDTO(Cor entity) {

        System.out.println(5);
        return new CorDTOforCorEntradaDTO(entity);
    }

    @Override
    public Cor makeEntityfromDTO(CorDTOforCorEntradaDTO dto) {
        System.out.println(1);
        return new Cor(dto.getId(), dto.getReferenciaNaFabrica(), dto.getNome(),
                dto.getObservacoes(), getQuantidadeEstoque());
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
}
