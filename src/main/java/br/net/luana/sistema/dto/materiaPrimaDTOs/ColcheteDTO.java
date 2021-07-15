package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Colchete;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.dto.tipoDTOs.TipoColcheteDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class ColcheteDTO extends MateriaPrimaDTO<Colchete, ColcheteDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private CorDTO corDTO = new CorDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private TipoColcheteDTO tipoColchete = new TipoColcheteDTO();

    private List<CorDTO> cores = new ArrayList<>();

    public ColcheteDTO() {
    }

    public ColcheteDTO(Colchete entity) {
        super(entity);
        this.tipoColchete = tipoColchete.makeDTO(entity.getTipoColchete());
        this.cores = corDTO.makeListDTO(entity.getCores());
    }

    @Override
    public ColcheteDTO makeDTO(Colchete entity) {
        return new ColcheteDTO(entity);
    }

    @Override
    public Colchete makeEntityfromDTO(ColcheteDTO dto) {
        return new Colchete(dto.getId(), dto.getReferenciaNaFabrica(), dto.getObservacoes(), dto.getDesuso(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), dto.getFornecedor(),
                tipoColchete.makeEntityfromDTO(dto.getTipoColchete()));
    }

    public TipoColcheteDTO getTipoColchete() {
        return tipoColchete;
    }

    public void setTipoColchete(TipoColcheteDTO tipoColchete) {
        this.tipoColchete = tipoColchete;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }
}
