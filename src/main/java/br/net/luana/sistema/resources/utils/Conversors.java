package br.net.luana.sistema.resources.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conversors {

    private static DateTimeFormatter dataSemHorario = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter dataComHorario = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static LocalDate stringToLocalDateSemHorario(String data) {
        return LocalDate.parse(data, dataSemHorario);
    }

    public static LocalDate stringToLocalDateComHorario(String data) {
        return LocalDate.parse(data, dataComHorario);
    }

}
