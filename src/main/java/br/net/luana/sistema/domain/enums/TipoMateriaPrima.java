package br.net.luana.sistema.domain.enums;

public enum TipoMateriaPrima {
    TECIDO(1, "Tecido"),
    BOJO(2, "Bojo"),
    RENDA(3, "Renda"),
    ALCA(4, "Alca"),
    LINHA(5, "Linha"),
    ELASTICO(6, "Elastico"),
    COLCHETE(7, "Colchete");

    private int codigo;
    private String descricao;

    TipoMateriaPrima(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoMateriaPrima toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (TipoMateriaPrima tipoMateriaPrima : TipoMateriaPrima.values()) {
            if(codigo.equals(tipoMateriaPrima.getCodigo())){
                return tipoMateriaPrima ;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
