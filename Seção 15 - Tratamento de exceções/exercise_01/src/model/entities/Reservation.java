package model.entities;

import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MILLIS;

public class Reservation {

    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
//        long diff = MILLIS.between(checkOut, checkIn);
//        long diff = DAYS.between(checkIn, checkOut);
//        return TimeUnit.MILLISECONDS.toDays(diff);
        return DAYS.between(checkIn, checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            throw new DomainException("Reservation dates for update must be future dates"); //new ≥ instancia uma exceção
            //IllegalArgumentException -> erro nos argumentos do método
        }
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + fmt.format(checkIn)
                + ", check-out: "
                + fmt.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}
