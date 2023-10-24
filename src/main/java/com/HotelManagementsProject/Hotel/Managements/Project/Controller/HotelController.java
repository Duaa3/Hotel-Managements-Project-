package com.HotelManagementsProject.Hotel.Managements.Project.Controller;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Hotel;
import com.HotelManagementsProject.Hotel.Managements.Project.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<String> createHotel(@RequestBody @Valid Hotel hotel) {
        try {
            Hotel createdHotel = hotelService.createHotel(hotel);
            String message = "Hotel added successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            String errorMessage = "Hotel not created: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @PutMapping("/update/{hotelId}")
    public ResponseEntity<String> updateHotel(@PathVariable Long hotelId, @RequestBody Hotel updatedHotel) {
        try {
            Hotel hotel = hotelService.updateHotel(hotelId, updatedHotel);
            if (hotel != null) {
                String message = "Hotel updated successfully";
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } else {
                String errorMessage = "Hotel not found with ID: " + hotelId;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Hotel update failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<String> getHotelById(@PathVariable Long hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        if (hotel != null) {
            return ResponseEntity.status(HttpStatus.OK).body(hotel.toString());
        } else {
            String errorMessage = "Hotel not found with ID: " + hotelId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.OK).body(hotels.toString());
    }

    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long hotelId) {
        try {
            hotelService.deleteHotel(hotelId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Hotel deleted successfully");
        } catch (Exception e) {
            String errorMessage = "Hotel delete failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
}
