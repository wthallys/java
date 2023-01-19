package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.print("Check-out date (dd/MM/yyyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), fmt);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyyy): ");
            checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.print("Check-out date (dd/MM/yyyyy): ");
            checkOut = LocalDate.parse(sc.next(), fmt);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (DomainException exception) {
            System.out.println("Error in reservation: " + exception.getMessage());
        }
        catch (DateTimeParseException exception) {
            System.out.println("Invalid date format");
        }
        catch (RuntimeException exception) {
            System.out.println("Unexpected error!");
        }
    }
}
