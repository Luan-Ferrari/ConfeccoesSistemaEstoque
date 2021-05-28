package br.net.luana.sistema.domain.enums;

public enum TipoTelefone {

    FIXO(1, "Fixo"),
    CELULAR(2, "Celular"),
    WHATSAPP(3, "Whatsapp"),
    CELULAR_E_WHATSAPP(4, "Celular e Whatsapp");

    private int codigo;
    private String descricao;

    TipoTelefone(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoTelefone toEnum(Integer codigo) {
        if(codigo == null){
            return null;
        }

        for(TipoTelefone tt : TipoTelefone.values()) {
            if(codigo.equals(tt.getCodigo())) {
                return tt;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
