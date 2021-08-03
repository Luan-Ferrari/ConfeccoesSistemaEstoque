package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.Cidade;
import br.net.luana.sistema.domain.Fornecedor;
import br.net.luana.sistema.services.validation.FornecedorInsert;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@FornecedorInsert
@Component
public class FornecedorDTO
        extends MasterDTOImpl<Fornecedor, FornecedorDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private TelefoneDTO telefoneDTO = new TelefoneDTO();

    private Integer id;

    @NotBlank (message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_2, message = ValidationsValues.LENGTH)
    private String nome;

    @NotBlank (message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private String cnpj;

    @Email (message = ValidationsValues.EMAIL)
    private String email;

    private List<TelefoneDTO> telefones = new ArrayList<>();

    @NotBlank (message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_3, message = ValidationsValues.LENGTH)
    private String descricao;

    @NotNull(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private Cidade cidade;


    public FornecedorDTO() {
    }

    public FornecedorDTO(Fornecedor entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cnpj = entity.getCnpj();
        this.email = entity.getEmail();
        this.descricao = entity.getDescricao();
        this.cidade = entity.getCidade();
        this.telefones = telefoneDTO.makeListDTO(entity.getTelefones());
    }

    @Override
    public FornecedorDTO makeDTO(Fornecedor entity) {
        return new FornecedorDTO(entity);
    }

    @Override
    public Fornecedor makeEntityfromDTO(FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor(dto.getId(), dto.getNome(), dto.getCnpj(),
                dto.getEmail(), dto.getDescricao(), dto.getCidade());
        for(TelefoneDTO telefoneDTO : dto.getTelefones()) {
            fornecedor.getTelefones().add(telefoneDTO.makeEntityfromDTO(telefoneDTO));
        }
        return fornecedor;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
