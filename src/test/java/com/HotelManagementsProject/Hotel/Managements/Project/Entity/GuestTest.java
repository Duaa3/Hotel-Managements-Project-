package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import static org.junit.jupiter.api.Assertions.*;




import org.junit.Test;

import java.util.List;


public class GuestTest {


    // Creating a new Guest object with valid parameters should set the object's attributes correctly.
    @Test
    public void test_create_guest_with_valid_parameters() {
        Guest guest = new Guest(1L, "John", "Doe", "john.doe@example.com", "1234567890", "123 Main St", "USA", "1234567890", null);

        assertEquals(1L, guest.getId());
        assertEquals("John", guest.getFirstName());
        assertEquals("Doe", guest.getLastName());
        assertEquals("john.doe@example.com", guest.getEmail());
        assertEquals("1234567890", guest.getPhoneNumber());
        assertEquals("123 Main St", guest.getAddress());
        assertEquals("USA", guest.getNationality());
        assertEquals("1234567890", guest.getIdentificationNumber());
        assertNull(guest.getReservations());
    }

    // Updating a Guest object's attributes should correctly modify the object's state.
    @Test
    public void test_update_guest_attributes() {
        Guest guest = new Guest(1L, "John", "Doe", "john.doe@example.com", "1234567890", "123 Main St", "USA", "1234567890", null);

        guest.setFirstName("Jane");
        guest.setLastName("Smith");
        guest.setEmail("jane.smith@example.com");
        guest.setPhoneNumber("0987654321");
        guest.setAddress("456 Elm St");
        guest.setNationality("Canada");
        guest.setIdentificationNumber("0987654321");

        assertEquals("Jane", guest.getFirstName());
        assertEquals("Smith", guest.getLastName());
        assertEquals("jane.smith@example.com", guest.getEmail());
        assertEquals("0987654321", guest.getPhoneNumber());
        assertEquals("456 Elm St", guest.getAddress());
        assertEquals("Canada", guest.getNationality());
        assertEquals("0987654321", guest.getIdentificationNumber());
    }

    // Adding a Reservation object to a Guest's list of reservations should update the Guest object's state correctly.
    @Test
    public void test_add_reservation_to_guest() {
        Guest guest = new Guest(1L, "John", "Doe", "john.doe@example.com", "1234567890", "123 Main St", "USA", "1234567890", null);
        Reservation reservation = new Reservation(1L, null, guest, null, null, null, null, 0.0);

        guest.setReservations(List.of(reservation));

        assertEquals(1, guest.getReservations().size());
        assertEquals(reservation, guest.getReservations().get(0));
    }




}