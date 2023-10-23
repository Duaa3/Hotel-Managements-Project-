package com.HotelManagementsProject.Hotel.Managements.Project.Service;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Guest;
import com.HotelManagementsProject.Hotel.Managements.Project.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest registerGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest updateGuest(Long id, Guest updatedGuest) {
        return guestRepository.save(updatedGuest);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}

