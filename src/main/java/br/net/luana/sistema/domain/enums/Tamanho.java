package br.net.luana.sistema.domain.enums;

public enum Tamanho {
    t34(1, "34"),
    t36(2, "36"),
    PP(3, "PP"),
    P(4, "P"),
    M(5, "M"),
    G(6, "G"),
    GG(7, "GG"),
    t48(8, "48"),
    t50(9, "50"),
    t52(10, "52");

    private int codigo;
    private String descricao;

    Tamanho (int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Tamanho toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (Tamanho tamanho : Tamanho.values()) {
            if(codigo.equals(tamanho.getCodigo())){
                return tamanho;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
