package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Linha;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.dto.tipoDTOs.TipoLinhaDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class LinhaDTO extends MateriaPrimaDTO<Linha, LinhaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private CorDTO corDTO = new CorDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private TipoLinhaDTO tipoLinha = new TipoLinhaDTO();

    private List<CorDTO> cores = new ArrayList<>();

    public LinhaDTO() {
    }

    public LinhaDTO(Linha entity) {
        super(entity);
        this.tipoLinha = tipoLinha.makeDTO(entity.getTipoLinha());
        this.cores = corDTO.makeListDTO(entity.getCores());
    }

    @Override
    public LinhaDTO makeDTO(Linha entity) {
        return new LinhaDTO(entity);
    }

    @Override
    public Linha makeEntityfromDTO(LinhaDTO dto) {
        return new Linha(dto.getId(), dto.getReferenciaNaFabrica(), dto.getObservacoes(), dto.getDesuso(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), dto.getQuantidadeKanBan(),  dto.getFornecedor(),
                tipoLinha.makeEntityfromDTO(dto.getTipoLinha()));
    }

    public TipoLinhaDTO getTipoLinha() {
        return tipoLinha;
    }

    public void setTipoLinha(TipoLinhaDTO tipoLinha) {
        this.tipoLinha = tipoLinha;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }
}
