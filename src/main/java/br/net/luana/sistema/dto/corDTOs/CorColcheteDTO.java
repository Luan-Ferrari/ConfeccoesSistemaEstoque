package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorColchete;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.materiaPrimaDTOs.ColcheteDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class CorColcheteDTO extends CorDTO<CorColchete, CorColcheteDTO, Integer> {
    private static final long serialVerialUID = 1L;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private ColcheteDTO colchete = new ColcheteDTO();

    public CorColcheteDTO() {
    }

    public CorColcheteDTO(CorColchete entity) {
        super(entity);
        this.colchete = colchete.makeDTO(entity.getColchete());
    }

    @Override
    public CorColcheteDTO makeDTO(CorColchete entity) {
        return new CorColcheteDTO(entity);
    }

    @Override
    public CorColchete makeEntityfromDTO(CorColcheteDTO dto) {
        return new CorColchete(dto.getId(), dto.getReferenciaNaFabrica(), dto.getNome(), dto.getObservacoes(),
                dto.getQuantidadeEstoque(), dto.getQuantidadeKanBan(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), colchete.makeEntityfromDTO(dto.getColchete()));
    }

    public ColcheteDTO getColchete() {
        return colchete;
    }

    public void setColchete(ColcheteDTO colchete) {
        this.colchete = colchete;
    }
}
