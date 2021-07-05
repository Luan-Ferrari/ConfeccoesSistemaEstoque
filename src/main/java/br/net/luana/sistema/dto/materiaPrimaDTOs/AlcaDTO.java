package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.materiasprimas.Alca;
import br.net.luana.sistema.dto.tipoDTOs.TipoAlcaDTO;
import org.springframework.stereotype.Component;

@Component
public class AlcaDTO extends MateriaPrimaDTO<Alca, AlcaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private TipoAlcaDTO tipoAlca = new TipoAlcaDTO();

    public AlcaDTO() {
    }

    public AlcaDTO(Alca entity) {
        super(entity);
        this.tipoAlca = tipoAlca.makeDTO(entity.getTipoAlca());
    }

    @Override
    public AlcaDTO makeDTO(Alca entity) {
        return new AlcaDTO(entity);
    }

    @Override
    public Alca makeEntityfromDTO(AlcaDTO dto) {
        return new Alca(dto.getId(), dto.getReferenciaNaFabrica(), dto.getObservacoes(), dto.getDesuso(),
                dto.getUnidadeMedida(), dto.getFornecedor(), tipoAlca.makeEntityfromDTO(dto.tipoAlca));
    }

    public TipoAlcaDTO getTipoAlca() {
        return tipoAlca;
    }

    public void setTipoAlca(TipoAlcaDTO tipoAlca) {
        this.tipoAlca = tipoAlca;
    }
}
