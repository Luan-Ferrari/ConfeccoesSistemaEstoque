package br.net.luana.sistema.domain.enums;

public enum UnidadeMedida {
    QUILOS(1, "Quilos"),
    METROS(2, "Metros"),
    PARES(3, "Pares"),
    UNIDADES(4, "Unidades"),
    ROLOS(5, "Rolos"),
    PEÇAS(6, "Peças");

    private int codigo;
    private String descricao;

    UnidadeMedida(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static UnidadeMedida toEnum(Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (UnidadeMedida um : UnidadeMedida.values()) {
            if(codigo.equals((um.getCodigo()))) {
                return um;
            }
        }

        throw new IllegalArgumentException("ID inválido: " + codigo);
    }
}
