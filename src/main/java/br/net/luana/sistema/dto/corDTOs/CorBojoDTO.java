package br.net.luana.sistema.dto.corDTOs;

import br.net.luana.sistema.domain.cores.CorBojo;
import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.dto.CaixaBojoDTOforCorBojoDTO;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.materiaPrimaDTOs.BojoDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Component
public class CorBojoDTO extends CorDTO<CorBojo, CorBojoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private CaixaBojoDTOforCorBojoDTO caixaBojoDTOforCorBojoDTO = new CaixaBojoDTOforCorBojoDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private BojoDTO bojo = new BojoDTO();

    @NotEmpty(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private List<CaixaBojoDTOforCorBojoDTO> caixas = new ArrayList<>();

    public CorBojoDTO() {
    }

    public CorBojoDTO(CorBojo entity) {
        super(entity);
        this.bojo = bojo.makeDTO(entity.getBojo());
        this.caixas = caixaBojoDTOforCorBojoDTO.makeListDTO(entity.getCaixas());
    }

    @Override
    public CorBojoDTO makeDTO(CorBojo entity) { return new CorBojoDTO(entity); }

    @Override
    public CorBojo makeEntityfromDTO(CorBojoDTO dto) {
        CorBojo entity = new CorBojo(dto.getId(), dto.getReferenciaNaFabrica(), dto.getNome(), dto.getObservacoes(),
                dto.getQuantidadeEstoque(),dto.getQuantidadeKanBan(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), bojo.makeEntityfromDTO(dto.getBojo()));
        for (CaixaBojoDTOforCorBojoDTO caixa : dto.getCaixas()) {
            entity.getCaixas().add(caixaBojoDTOforCorBojoDTO.makeEntityfromDTO(caixa));
        }
        return entity;
    }

    public BojoDTO getBojo() {
        return bojo;
    }

    public void setBojo(BojoDTO bojo) {
        this.bojo = bojo;
    }

    public List<CaixaBojoDTOforCorBojoDTO> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<CaixaBojoDTOforCorBojoDTO> caixas) {
        this.caixas = caixas;
    }
}
