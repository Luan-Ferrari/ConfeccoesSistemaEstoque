package br.net.luana.sistema.dto.composicoesDTOs;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.domain.composicoes.ModoLavar;
import br.net.luana.sistema.dto.MasterDTOImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComposicaoDTO extends MasterDTOImpl<Composicao, ComposicaoDTO, Integer> {
    private static final long serialVerisonUID = 1L;

    private FioDTO fioDTO = new FioDTO();

    private Integer id;
    private Integer numero;
    private List<FioDTO> fios = new ArrayList<>();
    private List<Integer> porcentagens = new ArrayList<>();
    private List<ModoLavar> modoLavar = new ArrayList<>();

    public ComposicaoDTO() {
    }

    public ComposicaoDTO(Composicao entity) {
        this.id = entity.getId();
        this.numero = entity.getNumero();
        this.fios = fioDTO.makeListDTO(entity.getFios());
        this.porcentagens = entity.getPorcentagens();
        this.modoLavar = entity.getModoLavar();
    }

    @Override
    public ComposicaoDTO makeDTO(Composicao entity) {
        return new ComposicaoDTO(entity);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<FioDTO> getFios() {
        return fios;
    }

    public void setFios(List<FioDTO> fios) {
        this.fios = fios;
    }

    public List<Integer> getPorcentagens() {
        return porcentagens;
    }

    public void setPorcentagens(List<Integer> porcentagens) {
        this.porcentagens = porcentagens;
    }

    public List<ModoLavar> getModoLavar() {
        return modoLavar;
    }

    public void setModoLavar(List<ModoLavar> modoLavar) {
        this.modoLavar = modoLavar;
    }
}
