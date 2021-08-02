package br.net.luana.sistema.dto;

import br.net.luana.sistema.domain.Contato;
import br.net.luana.sistema.domain.Telefone;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContatoDTO
        extends MasterDTOImpl<Contato, ContatoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private TelefoneDTO telefoneDTO = new TelefoneDTO();
    private FornecedorDTO fornecedorDTO = new FornecedorDTO();

    private Integer id;

    @NotBlank (message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_2, message = ValidationsValues.LENGTH)
    private String nome;

    @NotBlank (message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private String funcao;

    @Email (message = ValidationsValues.EMAIL)
    private String email;

    private List<FornecedorDTO> fornecedor = new ArrayList<>();

    private List<TelefoneDTO> telefones = new ArrayList<>();

    public ContatoDTO() {
    }

    public ContatoDTO(Contato entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.funcao = entity.getFuncao();
        this.email = entity.getEmail();
        this.fornecedor = fornecedorDTO.makeListDTO(entity.getFornecedores());
        this.telefones = telefoneDTO.makeListDTO(entity.getTelefones());
    }

    @Override
    public ContatoDTO makeDTO(Contato entity) {
        return new ContatoDTO(entity);
    }

    @Override
    public Contato makeEntityfromDTO(ContatoDTO dto) {
        Contato contato = new Contato(dto.getId(), dto.getNome(), dto.getFuncao(),
                dto.getEmail());
        for(int i = 0; i < telefones.size(); i++) {
            Telefone telefone = new Telefone();
            telefone = telefoneDTO.makeEntityfromDTO(dto.getTelefones().get(i));
            contato.getTelefones().add(telefone);
        }

        for(FornecedorDTO fornecedor : dto.getFornecedor() ) {
            contato.getFornecedores().add(fornecedorDTO.makeEntityfromDTO(fornecedor));
        }
        return contato;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<FornecedorDTO> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<FornecedorDTO> fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }
}
