package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorElastico;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.materiaPrimaDTOs.ElasticoDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class CorElasticoDTO extends CorDTO<CorElastico, CorElasticoDTO, Integer> {
    private static final long serialVerialUID = 1L;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private ElasticoDTO elastico = new ElasticoDTO();

    public CorElasticoDTO() {
    }

    public CorElasticoDTO(CorElastico entity) {
        super(entity);
        this.elastico = elastico.makeDTO(entity.getElastico());
    }

    @Override
    public CorElasticoDTO makeDTO(CorElastico entity) {
        return new CorElasticoDTO(entity);
    }

    @Override
    public CorElastico makeEntityfromDTO(CorElasticoDTO dto) {
        return new CorElastico(dto.getId(), dto.getReferenciaNaFabrica(), dto.getNome(), dto.getObservacoes(),
                dto.getQuantidadeEstoque(), dto.getQuantidadeKanBan(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), elastico.makeEntityfromDTO(dto.getElastico()));
    }

    public ElasticoDTO getElastico() {
        return elastico;
    }

    public void setElastico(ElasticoDTO elastico) {
        this.elastico = elastico;
    }
}
