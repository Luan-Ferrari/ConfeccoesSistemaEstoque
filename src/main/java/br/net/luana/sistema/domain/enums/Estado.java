package br.net.luana.sistema.domain.enums;

public enum Estado {
    RS(1, "Rio Grande do Sul"),
    SC(2, "Santa Catarina"),
    PR(3, "Paraná"),
    SP(4, "São Paulo"),
    RJ(5, "Rio de Janeiro"),
    MG(6, "Minas Gerais"),
    ES(7, "Espirito Santo"),
    DF(8, "Distrito Federal"),
    GO(9, "Goiás"),
    MT(10, "Mato Grosso"),
    MS(11, "Mato Grosso do Sul"),
    BA(12, "Bahia"),
    TO(13, "Tocantins"),
    SE(14, "Sergipe"),
    AL(15, "Alagoas"),
    PE(16, "Pernambuco"),
    PB(17, "Paraíba"),
    RN(18, "Rio Grande do Norte"),
    CE(19, "Ceará"),
    PI(20, "Piauí"),
    MA(21, "Maranhão"),
    PA(22, "Pará"),
    AP(23, "Amapá"),
    RO(24, "Rondônia"),
    AM(25, "Amazonas"),
    RR(26, "Roraíma"),
    AC(27, "Acre");

    private int codigo;
    private String descricao;

    Estado(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Estado toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (Estado categoriaModoLavar : Estado.values()) {
            if(codigo.equals(categoriaModoLavar.getCodigo())){
                return categoriaModoLavar;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
