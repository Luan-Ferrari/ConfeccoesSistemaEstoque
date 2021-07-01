package br.net.luana.sistema.dto.composicoesDTOs;

import br.net.luana.sistema.domain.composicoes.Fio;
import br.net.luana.sistema.dto.MasterDTOImpl;
import org.springframework.stereotype.Component;

@Component
public class FioDTO extends MasterDTOImpl<Fio, FioDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public FioDTO() {
    }

    public FioDTO(Fio entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    @Override
    public FioDTO makeDTO(Fio entity) {
        return new FioDTO(entity);
    }

    @Override
    public Fio makeEntityfromDTO(FioDTO dto) {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
