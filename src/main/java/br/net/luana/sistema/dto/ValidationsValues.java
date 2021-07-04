package br.net.luana.sistema.dto;

public class ValidationsValues {

    public static final int MIN = 3;
    public static final int MAX_1 = 30;
    public static final int MAX_2 = 80;
    public static final int MAX_3 = 240;

    public static final int DIGITS_INTEGER = 4;
    public static final int DIGITS_FRACTION = 2;

    public static final String NOT_BLANK_OR_NOT_NULL_MESSAGE = "Preenchimento Obrigatório";
    public static final String LENGTH = "O tamanho deve ser entre {min} e {max} caracteres";
    public static final String PAST_OR_PRESENT_MESSAGE = "A data deve ser igual ou anterior a data atual";
    public static final String DIGITS_MESSAGE = "O valor deve conter {integer} digitos inteiros e {fraction} casas decimais";

}
