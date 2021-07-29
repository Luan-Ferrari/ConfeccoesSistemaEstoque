package br.net.luana.sistema.domain.enums;

public enum FuncaoContato {
    VENDEDOR(1, "Vendedor"),
    TRANSPORTE(2, "Transporte"),
    DESPACHO(3, "Despacho"),
    ESCRITORIO(4, "Escritório"),
    FINANCEIRO(5, "Financeiro"),
    RECEPCAO(6, "Recepção"),
    MANUTENCAO(7, "Manutenção"),
    OUTROS(99, "Outros");

    private int codigo;
    private String descricao;

    FuncaoContato (int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static FuncaoContato toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (FuncaoContato fc : FuncaoContato.values()) {
            if(codigo.equals(fc.getCodigo())){
                return fc;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
