package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Elastico;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.dto.tipoDTOs.TipoElasticoDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class ElasticoDTO extends MateriaPrimaDTO<Elastico, ElasticoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private CorDTO corDTO = new CorDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private TipoElasticoDTO tipoElastico = new TipoElasticoDTO();

    private List<CorDTO> cores = new ArrayList<>();

    public ElasticoDTO() {
    }

    public ElasticoDTO(Elastico entity) {
        super(entity);
        this.tipoElastico = tipoElastico.makeDTO(entity.getTipoElastico());
        this.cores = corDTO.makeListDTO(entity.getCores());
    }

    @Override
    public ElasticoDTO makeDTO(Elastico entity) {
        return new ElasticoDTO(entity);
    }

    @Override
    public Elastico makeEntityfromDTO(ElasticoDTO dto) {
        return new Elastico(dto.getId(), dto.getReferenciaNaFabrica(), dto.getObservacoes(), dto.getDesuso(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), dto.getQuantidadeKanBan(), dto.getFornecedor(),
                tipoElastico.makeEntityfromDTO(dto.getTipoElastico()));
    }

    public TipoElasticoDTO getTipoElastico() {
        return tipoElastico;
    }

    public void setTipoElastico(TipoElasticoDTO tipoElastico) {
        this.tipoElastico = tipoElastico;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }
}
