package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
public class HotelTest {


    // Hotel object can be created with valid parameters
    @Test
    public void test_createHotelWithValidParameters() {
        Hotel hotel = new Hotel(1L, "Hotel A", "Location A", "Contact A");

        assertEquals(1L, hotel.getId().longValue());
        assertEquals("Hotel A", hotel.getName());
        assertEquals("Location A", hotel.getLocation());
        assertEquals("Contact A", hotel.getContactInformation());
    }

    // Hotel object can be created with null parameters
    @Test
    public void test_createHotelWithNullParameters() {
        Hotel hotel = new Hotel(null, null, null, null);

        assertNull(hotel.getId());
        assertNull(hotel.getName());
        assertNull(hotel.getLocation());
        assertNull(hotel.getContactInformation());
    }

    // Hotel object parameters can be modified
    @Test
    public void test_modifyHotelParameters() {
        Hotel hotel = new Hotel(1L, "Hotel A", "Location A", "Contact A");

        hotel.setId(2L);
        hotel.setName("Hotel B");
        hotel.setLocation("Location B");
        hotel.setContactInformation("Contact B");

        assertEquals(2L, hotel.getId().longValue());
        assertEquals("Hotel B", hotel.getName());
        assertEquals("Location B", hotel.getLocation());
        assertEquals("Contact B", hotel.getContactInformation());
    }

    // Hotel object can be created with empty string parameters
    @Test
    public void test_createHotelWithEmptyStringParameters() {
        Hotel hotel = new Hotel(1L, "", "", "");

        assertEquals(1L, hotel.getId().longValue());
        assertEquals("", hotel.getName());
        assertEquals("", hotel.getLocation());
        assertEquals("", hotel.getContactInformation());
    }

    // Hotel object can be created with id parameter as null
    @Test
    public void test_createHotelWithNullIdParameter() {
        Hotel hotel = new Hotel(null, "Hotel A", "Location A", "Contact A");

        assertNull(hotel.getId());
        assertEquals("Hotel A", hotel.getName());
        assertEquals("Location A", hotel.getLocation());
        assertEquals("Contact A", hotel.getContactInformation());
    }

    // Hotel object can be created with id parameter as negative value
    @Test
    public void test_createHotelWithNegativeIdParameter() {
        Hotel hotel = new Hotel(-1L, "Hotel A", "Location A", "Contact A");

        assertEquals(-1L, hotel.getId().longValue());
        assertEquals("Hotel A", hotel.getName());
        assertEquals("Location A", hotel.getLocation());
        assertEquals("Contact A", hotel.getContactInformation());
    }

}