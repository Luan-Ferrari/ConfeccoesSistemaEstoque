package br.net.luana.sistema.domain.enums;

public enum PerfilUsuario {
    ADMIN(1, "ROLE_ADMIN"),
    USUARIO(2, "ROLE_USUARIO");

    private int codigo;
    private String descricao;

    PerfilUsuario(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PerfilUsuario toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (PerfilUsuario perfilUsuario : PerfilUsuario.values()) {
            if(codigo.equals(perfilUsuario.getCodigo())){
                return perfilUsuario;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
