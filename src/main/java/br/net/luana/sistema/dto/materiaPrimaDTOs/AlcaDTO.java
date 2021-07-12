package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Alca;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.dto.tipoDTOs.TipoAlcaDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class AlcaDTO extends MateriaPrimaDTO<Alca, AlcaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private CorDTO corDTO = new CorDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private TipoAlcaDTO tipoAlca = new TipoAlcaDTO();

    private List<CorDTO> cores = new ArrayList<>();

    public AlcaDTO() {
    }

    public AlcaDTO(Alca entity) {
        super(entity);
        this.tipoAlca = tipoAlca.makeDTO(entity.getTipoAlca());
        this.cores = corDTO.makeListDTO(entity.getCores());
    }

    @Override
    public AlcaDTO makeDTO(Alca entity) {
        return new AlcaDTO(entity);
    }

    @Override
    public Alca makeEntityfromDTO(AlcaDTO dto) {
        return new Alca(dto.getId(), dto.getReferenciaNaFabrica(), dto.getObservacoes(), dto.getDesuso(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), dto.getFornecedor(),
                tipoAlca.makeEntityfromDTO(dto.getTipoAlca()));
    }

    public TipoAlcaDTO getTipoAlca() {
        return tipoAlca;
    }

    public void setTipoAlca(TipoAlcaDTO tipoAlcaDTO) {
        this.tipoAlca = tipoAlcaDTO;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }
}
