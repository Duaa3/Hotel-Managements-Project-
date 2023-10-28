package com.HotelManagementsProject.Hotel.Managements.Project.Service;
import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Hotel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
public class HotelServiceTest {
    @Autowired
    private HotelService hotelService;

    // createHotel method throws an exception when given a hotel with a null name
    @Test
    public void test_create_hotel_null_name() {
        // Arrange
        Hotel hotel = new Hotel(1L, null, "Location A", "Contact A");

        // Act and Assert
        assertThrows(Exception.class, () -> hotelService.createHotel(hotel));
    }

    // updateHotel method throws an exception when given an id that does not exist in the repository
    @Test
    public void test_update_hotel_invalid_id() {
        // Arrange
        Long invalidId = 100L;
        Hotel updatedHotel = new Hotel(1L, "Updated Hotel", "Updated Location", "Updated Contact");

        // Act and Assert
        assertThrows(Exception.class, () -> hotelService.updateHotel(invalidId, updatedHotel));
    }

}