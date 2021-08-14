package br.net.luana.sistema.dto.usuarios;

import br.net.luana.sistema.domain.usuarios.Usuario;
import br.net.luana.sistema.dto.MasterDTOImpl;
import br.net.luana.sistema.dto.ValidationsValues;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Component
public class UsuarioDTO
        extends MasterDTOImpl<Usuario, UsuarioDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_2, message = ValidationsValues.LENGTH)
    private String nome;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    @Override
    public UsuarioDTO makeDTO(Usuario entity) {
        return new UsuarioDTO(entity);
    }

    @Override
    public Usuario makeEntityfromDTO(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto.getId(), dto.getNome(), passwordEncoder.encode(dto.getSenha()));
        return usuario;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}





