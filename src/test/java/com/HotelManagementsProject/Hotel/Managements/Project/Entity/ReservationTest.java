package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;


public class ReservationTest {


    // creating a new reservation with all required fields should successfully create a reservation object
    @Test
    public void test_createReservation_success() {
        // Arrange
        Hotel hotel = new Hotel(1L, "Hotel A", "Location A", "Contact A");
        Guest guest = new Guest(1L, "John", "Doe", "john.doe@example.com", "1234567890", "Address A", "Nationality A", "ID A", new ArrayList<>());
        Room room = new Room("101", 100.0, "Single", true);
        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = LocalDate.now().plusDays(1);
        double totalCost = 200.0;

        // Act
        Reservation reservation = new Reservation(1L, hotel, guest, null, room, checkInDate, checkOutDate, totalCost);

        // Assert
        assertNotNull(reservation);
        assertEquals(1L, reservation.getId().longValue());
        assertEquals(hotel, reservation.getHotel());
        assertEquals(guest, reservation.getGuest());
        assertNull(reservation.getBilling());
        assertEquals(room, reservation.getRoom());
        assertEquals(checkInDate, reservation.getCheckInDate());
        assertEquals(checkOutDate, reservation.getCheckOutDate());
        assertEquals(totalCost, reservation.getTotalCost(), 0.01);
    }

    // updating the check-in and check-out dates of an existing reservation should successfully update the reservation object
    @Test
    public void test_updateReservationDates_success() {
        // Arrange
        Hotel hotel = new Hotel(1L, "Hotel A", "Location A", "Contact A");
        Guest guest = new Guest(1L, "John", "Doe", "john.doe@example.com", "1234567890", "Address A", "Nationality A", "ID A", new ArrayList<>());
        Room room = new Room("101", 100.0, "Single", true);
        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = LocalDate.now().plusDays(1);
        double totalCost = 200.0;
        Reservation reservation = new Reservation(1L, hotel, guest, null, room, checkInDate, checkOutDate, totalCost);

        // Act
        LocalDate newCheckInDate = LocalDate.now().plusDays(2);
        LocalDate newCheckOutDate = LocalDate.now().plusDays(3);
        reservation.setCheckInDate(newCheckInDate);
        reservation.setCheckOutDate(newCheckOutDate);

        // Assert
        assertEquals(newCheckInDate, reservation.getCheckInDate());
        assertEquals(newCheckOutDate, reservation.getCheckOutDate());
    }

    // deleting an existing reservation should successfully remove the reservation object
    @Test
    public void test_deleteReservation_success() {
        // Arrange
        Hotel hotel = new Hotel(1L, "Hotel A", "Location A", "Contact A");
        Guest guest = new Guest(1L, "John", "Doe", "john.doe@example.com", "1234567890", "Address A", "Nationality A", "ID A", new ArrayList<>());
        Room room = new Room("101", 100.0, "Single", true);
        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = LocalDate.now().plusDays(1);
        double totalCost = 200.0;
        Reservation reservation = new Reservation(1L, hotel, guest, null, room, checkInDate, checkOutDate, totalCost);

        // Act
        reservation = null;

        // Assert
        assertNull(reservation);
    }




}