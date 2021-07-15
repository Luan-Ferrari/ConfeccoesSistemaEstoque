package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorLinha;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.materiaPrimaDTOs.LinhaDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
public class CorLinhaDTO extends CorDTO<CorLinha, CorLinhaDTO, Integer> {
    private static final long serialVerialUID = 1L;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private LinhaDTO linha = new LinhaDTO();

    public CorLinhaDTO() {
    }

    public CorLinhaDTO(CorLinha entity) {
        super(entity);
        this.linha = linha.makeDTO(entity.getLinha());
    }

    @Override
    public CorLinhaDTO makeDTO(CorLinha entity) {
        return new CorLinhaDTO(entity);
    }

    @Override
    public CorLinha makeEntityfromDTO(CorLinhaDTO dto) {
        return new CorLinha(dto.getId(), dto.getReferenciaNaFabrica(), dto.getNome(), dto.getObservacoes(),
                dto.getQuantidadeEstoque(), linha.makeEntityfromDTO(dto.getLinha()));
    }

    public LinhaDTO getLinha() {
        return linha;
    }

    public void setLinha(LinhaDTO linha) {
        this.linha = linha;
    }
}
