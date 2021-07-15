package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorRenda;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.materiaPrimaDTOs.RendaDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class CorRendaDTO extends CorDTO<CorRenda, CorRendaDTO, Integer> {
    private static final long serialVerialUID = 1L;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private RendaDTO renda = new RendaDTO();

    public CorRendaDTO() {
    }

    public CorRendaDTO(CorRenda entity) {
        super(entity);
        this.renda = renda.makeDTO(entity.getRenda());
    }

    @Override
    public CorRendaDTO makeDTO(CorRenda entity) {
        return new CorRendaDTO(entity);
    }

    @Override
    public CorRenda makeEntityfromDTO(CorRendaDTO dto) {
        return new CorRenda(dto.getId(), dto.getReferenciaNaFabrica(), dto.getNome(), dto.getObservacoes(),
                dto.getQuantidadeEstoque(), renda.makeEntityfromDTO(dto.getRenda()));
    }

    public RendaDTO getRenda() {
        return renda;
    }

    public void setRenda(RendaDTO renda) {
        this.renda = renda;
    }
}
