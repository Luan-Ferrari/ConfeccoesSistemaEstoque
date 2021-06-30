package br.net.luana.sistema.domain.enums;

public enum CategoriaModoLavar {
    LAVAGEM(1, "Lavagem"),
    ALVEJAMENTO(2, "Alvejamento"),
    SECAGEM_TAMBOR(3, "Secagem em tambor"),
    SECAGEM_NATURAL(4, "Secagem natural"),
    PASSADORIA(5, "Passadoria"),
    LIMPEZA_SECO_PROFISSIONAL(6, "Limpeza a seco profissional"),
    LIMPEZA_UMIDO_PROFISSIONAL(7, "Limpeza a úmido profissional");

    private int codigo;
    private String descricao;

    CategoriaModoLavar(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CategoriaModoLavar toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (CategoriaModoLavar categoriaModoLavar : CategoriaModoLavar.values()) {
            if(codigo.equals(categoriaModoLavar.getCodigo())){
                return categoriaModoLavar;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
