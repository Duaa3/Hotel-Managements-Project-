package com.HotelManagementsProject.Hotel.Managements.Project.Controller;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Guest;
import com.HotelManagementsProject.Hotel.Managements.Project.Service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping("/register")
    public ResponseEntity<String> registerGuest(@RequestBody Guest guest) {
        try {
            Guest registeredGuest = guestService.registerGuest(guest);
            String message = "Guest registered successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            String errorMessage = "Guest not registered: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @GetMapping("/{guestId}")
    public ResponseEntity<Object> getGuestById(@PathVariable Long guestId) {
        Guest guest = guestService.getGuestById(guestId);
        if (guest != null) {
            return ResponseEntity.status(HttpStatus.OK).body(guest.toString());
        } else {
            String errorMessage = "Guest not found with ID: " + guestId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        return ResponseEntity.status(HttpStatus.OK).body(guests.toString());
    }

    @PutMapping("/update/{guestId}")
    public ResponseEntity<String> updateGuest(@PathVariable Long guestId, @RequestBody Guest updatedGuest) {
        try {
            Guest guest = guestService.updateGuest(guestId, updatedGuest);
            if (guest != null) {
                String message = "Guest updated successfully";
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } else {
                String errorMessage = "Guest not found with ID: " + guestId;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Guest update failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @DeleteMapping("/delete/{guestId}")
    public ResponseEntity<String> deleteGuest(@PathVariable Long guestId) {
        if (guestService.deleteGuest(guestId)) {
            return ResponseEntity.status(HttpStatus.OK).body("Guest deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guest not found with ID: " + guestId);
        }
    }

}
