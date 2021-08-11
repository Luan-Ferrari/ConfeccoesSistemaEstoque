package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Renda;
import br.net.luana.sistema.dto.FornecedorDTO;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.dto.tipoDTOs.TipoRendaDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class RendaDTO extends MateriaPrimaDTO<Renda, RendaDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private FornecedorDTO fornecedorDTO = new FornecedorDTO();
    private CorDTO corDTO = new CorDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private TipoRendaDTO tipoRenda = new TipoRendaDTO();

    private List<CorDTO> cores = new ArrayList<>();

    public RendaDTO() {
    }

    public RendaDTO(Renda entity) {
        super(entity);
        this.tipoRenda = tipoRenda.makeDTO(entity.getTipoRenda());
        this.cores = corDTO.makeListDTO(entity.getCores());
    }

    @Override
    public RendaDTO makeDTO(Renda entity) {
        return new RendaDTO(entity);
    }

    @Override
    public Renda makeEntityfromDTO(RendaDTO dto) {
        return new Renda(dto.getId(), dto.getReferenciaNaFabrica(), dto.getObservacoes(), dto.getDesuso(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), dto.getQuantidadeKanBan(),
                fornecedorDTO.makeEntityfromDTO(dto.getFornecedor()),
                tipoRenda.makeEntityfromDTO(dto.getTipoRenda()));
    }

    public TipoRendaDTO getTipoRenda() {
        return tipoRenda;
    }

    public void setTipoRenda(TipoRendaDTO tipoRenda) {
        this.tipoRenda = tipoRenda;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }
}
