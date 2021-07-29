package br.net.luana.sistema.dto.composicoesDTOs;

import br.net.luana.sistema.domain.composicoes.Composicao;
import br.net.luana.sistema.domain.composicoes.ComposicaoFio;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.dto.ValidationsValues;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class ComposicaoDTO extends MasterDTOImpl<Composicao, ComposicaoDTO, Integer> {
    private static final long serialVerisonUID = 1L;

    private FioDTO fioDTO = new FioDTO();
    private ModoLavarDTO modoLavarDTO = new ModoLavarDTO();

    private Integer id;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private Integer numero;

    @NotEmpty(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private List<FioDTO> fios = new ArrayList<>();

    @NotEmpty(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private List<Integer> porcentagens = new ArrayList<>();

    @NotEmpty(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private List<ModoLavarDTO> modoLavar = new ArrayList<>();

    public ComposicaoDTO() {
    }

    public ComposicaoDTO(Composicao entity) {
        this.id = entity.getId();
        this.numero = entity.getNumero();
        this.fios = fioDTO.makeListDTO(entity.getFios());
        this.porcentagens = entity.getPorcentagens();
        this.modoLavar = modoLavarDTO.makeListDTO(entity.getModoLavar());
    }

    @Override
    public ComposicaoDTO makeDTO(Composicao entity) {
        return new ComposicaoDTO(entity);
    }

    @Override
    public Composicao makeEntityfromDTO(ComposicaoDTO dto) {
        Composicao composicao = new Composicao();
        composicao.setId(dto.getId());
        composicao.setNumero(dto.getNumero());
        for (int i = 0; i < fios.size(); i++ ) {
            ComposicaoFio composicaoFio = new ComposicaoFio(composicao,
                    fioDTO.makeEntityfromDTO(fios.get(i)),
                    porcentagens.get(i) );
            composicao.getItensFios().add(composicaoFio);
        }
        for (ModoLavarDTO modoLavar : dto.getModoLavar()) {
            composicao.getItensModoLavar().add(modoLavarDTO.makeEntityfromDTO(modoLavar));
        }
        return composicao;
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

    public List<ModoLavarDTO> getModoLavar() {
        return modoLavar;
    }

    public void setModoLavar(List<ModoLavarDTO> modoLavar) {
        this.modoLavar = modoLavar;
    }


}
