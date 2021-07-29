package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Bojo;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.dto.tipoDTOs.TipoBojoDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class BojoDTO extends MateriaPrimaDTO<Bojo, BojoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private CorDTO corDTO = new CorDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private TipoBojoDTO tipoBojo = new TipoBojoDTO();

    private List<CorDTO> cores = new ArrayList<>();

    public BojoDTO() {
    }

    public BojoDTO(Bojo entity) {
        super(entity);
        this.tipoBojo = tipoBojo.makeDTO(entity.getTipoBojo());
        this.cores = corDTO.makeListDTO(entity.getCores());
    }

    @Override
    public BojoDTO makeDTO(Bojo entity) {
        return new BojoDTO(entity);
    }

    @Override
    public Bojo makeEntityfromDTO(BojoDTO dto) {
        return new Bojo(dto.getId(), dto.getReferenciaNaFabrica(), dto.getObservacoes(), dto.getDesuso(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), dto.getQuantidadeKanBan(),  dto.getFornecedor(),
                tipoBojo.makeEntityfromDTO(dto.getTipoBojo()));
    }

    public TipoBojoDTO getTipoBojo() {
        return tipoBojo;
    }

    public void setTipoBojo(TipoBojoDTO tipoBojo) {
        this.tipoBojo = tipoBojo;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }
}
