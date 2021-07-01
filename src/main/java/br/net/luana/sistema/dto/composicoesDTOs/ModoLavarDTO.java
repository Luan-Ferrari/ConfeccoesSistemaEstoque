package br.net.luana.sistema.dto.composicoesDTOs;

import br.net.luana.sistema.domain.composicoes.ModoLavar;
import br.net.luana.sistema.dto.MasterDTOImpl;
import org.springframework.stereotype.Component;

@Component
public class ModoLavarDTO extends MasterDTOImpl<ModoLavar, ModoLavarDTO, Integer> {
    private static final long serialVerisonUID = 1L;

    private Integer id;

    private String categoria;
    private String descricao;
    private String descricaoImagem;

    public ModoLavarDTO() {
    }

    public ModoLavarDTO(ModoLavar entity) {
        this.id = entity.getId();
        this.categoria = entity.getCategoria().getDescricao();
        this.descricao = entity.getDescricao();
        this.descricaoImagem = entity.getDescricaoImagem();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoImagem() {
        return descricaoImagem;
    }

    public void setDescricaoImagem(String descricaoImagem) {
        this.descricaoImagem = descricaoImagem;
    }

    @Override
    public ModoLavarDTO makeDTO(ModoLavar entity) {
        return new ModoLavarDTO(entity);
    }

    @Override
    public ModoLavar makeEntityfromDTO(ModoLavarDTO dto) {
        return null;
    }
}
