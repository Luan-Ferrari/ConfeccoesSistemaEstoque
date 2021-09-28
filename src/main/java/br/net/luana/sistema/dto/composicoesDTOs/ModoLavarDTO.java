package br.net.luana.sistema.dto.composicoesDTOs;

import br.net.luana.sistema.domain.composicoes.ModoLavar;
import br.net.luana.sistema.domain.enums.CategoriaModoLavar;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.dto.ValidationsValues;
import br.net.luana.sistema.services.imagesServices.ImageResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
public class ModoLavarDTO extends MasterDTOImpl<ModoLavar, ModoLavarDTO, Integer> {
    private static final long serialVerisonUID = 1L;

    @Autowired
    private ImageResolver imageResolver = new ImageResolver();

    private Integer id;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private Integer categoria;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private String descricao;

    private String imagem;

    public ModoLavarDTO() {
    }

    public ModoLavarDTO(ModoLavar entity) {
        this.id = entity.getId();
        this.categoria = entity.getCategoria().getCodigo();
        this.descricao = entity.getDescricao();
        this.imagem = (entity.getImageName() == null) ? null : imageResolver.getUriImagem(entity.getImageName());
    }

    @Override
    public ModoLavarDTO makeDTO(ModoLavar entity) {
        return new ModoLavarDTO(entity);
    }

    @Override
    public ModoLavar makeEntityfromDTO(ModoLavarDTO dto) {
        return new ModoLavar(dto.getId(), CategoriaModoLavar.toEnum(dto.getCategoria()), dto.getDescricao());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
