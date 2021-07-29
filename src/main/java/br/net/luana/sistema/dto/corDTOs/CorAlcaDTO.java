package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorAlca;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.materiaPrimaDTOs.AlcaDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class CorAlcaDTO extends CorDTO<CorAlca, CorAlcaDTO, Integer> {
    private static final long serialVerialUID = 1L;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private AlcaDTO alca = new AlcaDTO();

    public CorAlcaDTO() {
    }

    public CorAlcaDTO(CorAlca entity) {
        super(entity);
        this.alca = alca.makeDTO(entity.getAlca());
    }

    @Override
    public CorAlcaDTO makeDTO(CorAlca entity) {
        return new CorAlcaDTO(entity);
    }

    @Override
    public CorAlca makeEntityfromDTO(CorAlcaDTO dto) {
        return new CorAlca(dto.getId(), dto.getReferenciaNaFabrica(), dto.getNome(), dto.getObservacoes(),
                dto.getQuantidadeEstoque(), dto.getQuantidadeKanBan(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), alca.makeEntityfromDTO(dto.getAlca()));
    }

    public AlcaDTO getAlca() {
        return alca;
    }

    public void setAlca(AlcaDTO alca) {
        this.alca = alca;
    }
}
