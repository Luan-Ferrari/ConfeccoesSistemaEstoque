package br.net.luana.sistema.dto.materiaPrimaDTOs;

import br.net.luana.sistema.domain.enums.UnidadeMedida;
import br.net.luana.sistema.domain.materiasprimas.Tecido;
import br.net.luana.sistema.dto.FornecedorDTO;
import br.net.luana.sistema.dto.TecidoClasseDTOForTecidoDTO;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.dto.corDTOs.CorDTO;
import br.net.luana.sistema.dto.tipoDTOs.TipoTecidoDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class TecidoDTO extends MateriaPrimaDTO<Tecido, TecidoDTO, Integer> {
    private static final long serialVersionUID = 1L;

    private FornecedorDTO fornecedorDTO = new FornecedorDTO();
    private CorDTO corDTO = new CorDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private TipoTecidoDTO tipoTecido = new TipoTecidoDTO();

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private TecidoClasseDTOForTecidoDTO tecidoClasse = new TecidoClasseDTOForTecidoDTO();

    private List<CorDTO> cores = new ArrayList<>();

    public TecidoDTO() {
    }

    public TecidoDTO(Tecido entity) {
        super(entity);
        this.tipoTecido = tipoTecido.makeDTO(entity.getTipoTecido());
        this.tecidoClasse = tecidoClasse.makeDTO(entity.getClasse());
        this.cores = corDTO.makeListDTO(entity.getCores());
    }

    @Override
    public TecidoDTO makeDTO(Tecido entity) {
        return new TecidoDTO(entity);
    }

    @Override
    public Tecido makeEntityfromDTO(TecidoDTO dto) {
        return new Tecido(dto.getId(), dto.getReferenciaNaFabrica(), dto.getObservacoes(), dto.getDesuso(),
                UnidadeMedida.toEnum(dto.getUnidadeMedida()), dto.getQuantidadeKanBan(),
                fornecedorDTO.makeEntityfromDTO(dto.getFornecedor()),
                tipoTecido.makeEntityfromDTO(dto.getTipoTecido()),
                tecidoClasse.makeEntityfromDTO(dto.getTecidoClasse()));
    }

    public TipoTecidoDTO getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(TipoTecidoDTO tipoTecido) {
        this.tipoTecido = tipoTecido;
    }

    public TecidoClasseDTOForTecidoDTO getTecidoClasse() {
        return tecidoClasse;
    }

    public void setTecidoClasse(TecidoClasseDTOForTecidoDTO tecidoClasse) {
        this.tecidoClasse = tecidoClasse;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }
}
