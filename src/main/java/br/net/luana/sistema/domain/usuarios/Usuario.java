package br.net.luana.sistema.domain.usuarios;

import br.net.luana.sistema.domain.MasterDomain;
import br.net.luana.sistema.domain.enums.PerfilUsuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Usuario implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis")
    private Set<Integer> perfis = new HashSet<>();

    public Usuario() {
        addPerfil(PerfilUsuario.USUARIO);
    }

    public Usuario(Integer id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        addPerfil(PerfilUsuario.USUARIO);
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

    public Set<PerfilUsuario> getPerfil() {
        return perfis.stream().map(perfil -> PerfilUsuario.toEnum(perfil)).collect(Collectors.toSet());
    }

    public void addPerfil(PerfilUsuario perfil) {
        perfis.add(perfil.getCodigo());
    }
}
