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
    public ResponseEntity<Guest> registerGuest(@RequestBody Guest guest) {
        Guest registeredGuest = guestService.registerGuest(guest);
        return new ResponseEntity<>(registeredGuest, HttpStatus.CREATED);
    }

    @GetMapping("/{guestId}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long guestId) {
        Guest guest = guestService.getGuestById(guestId);
        if (guest != null) {
            return new ResponseEntity<>(guest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Guest>> getAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @PutMapping("/update/{guestId}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long guestId, @RequestBody Guest updatedGuest) {
        Guest guest = guestService.updateGuest(guestId, updatedGuest);
        if (guest != null) {
            return new ResponseEntity<>(guest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{guestId}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long guestId) {
        guestService.deleteGuest(guestId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

