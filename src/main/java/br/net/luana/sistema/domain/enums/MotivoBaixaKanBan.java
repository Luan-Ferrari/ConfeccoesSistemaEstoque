package br.net.luana.sistema.domain.enums;

public enum MotivoBaixaKanBan {
    USO(1, "Uso do material"),
    ERRO(2, "Erro de criação");

    private int codigo;
    private String descricao;

    MotivoBaixaKanBan(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static MotivoBaixaKanBan toEnum(Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (MotivoBaixaKanBan um : MotivoBaixaKanBan.values()) {
            if(codigo.equals((um.getCodigo()))) {
                return um;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + codigo);
    }
}
