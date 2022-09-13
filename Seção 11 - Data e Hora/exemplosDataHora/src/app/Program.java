package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        LocalDate d04 = LocalDate.parse("2022-08-23");
        LocalDateTime d05 = LocalDateTime.parse("2022-08-23T01:40:50");
        Instant d06 = Instant.parse("2022-08-23T01:40:50Z");
        ZonedDateTime d07 = ZonedDateTime.parse("2022-08-23T01:40:50-03:00"); //Java 11
//        Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00"); Java 17

        LocalDate d08 = LocalDate.parse("23/08/2002", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("23/08/2002 02:29", fmt2);

        LocalDate d10 = LocalDate.of(2022, 8, 23);
        LocalDateTime d11 = LocalDateTime.of(2022, 8, 23, 2, 35);

        System.out.println("d01 = " + d01);
        System.out.println("d02 = " + d02);
        System.out.println("d03 = " + d03);
        System.out.println("d04 = " + d04);
        System.out.println("d05 = " + d05);
        System.out.println("d06 = " + d06);
        System.out.println("d07 = " + d07.toInstant());
        System.out.println("d08 = " + d08);
        System.out.println("d09 = " + d09);
        System.out.println("d10 = " + d10);
        System.out.println("d11 = " + d11);

    }
}
