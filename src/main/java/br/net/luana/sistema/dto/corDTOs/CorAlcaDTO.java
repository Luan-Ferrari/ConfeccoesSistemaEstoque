package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorAlca;
import br.net.luana.sistema.dto.materiaPrimaDTOs.AlcaDTO;
import org.springframework.stereotype.Component;


@Component
public class CorAlcaDTO extends CorDTO<CorAlca, CorAlcaDTO, Integer> {
    private static final long serialVerialUID = 1L;

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
                dto.getQuantidadeEstoque(), alca.makeEntityfromDTO(dto.getAlca()));
    }

    public AlcaDTO getAlca() {
        return alca;
    }

    public void setAlca(AlcaDTO alca) {
        this.alca = alca;
    }
}
