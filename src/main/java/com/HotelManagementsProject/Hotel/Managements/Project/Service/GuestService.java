package com.HotelManagementsProject.Hotel.Managements.Project.Service;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Guest;
import com.HotelManagementsProject.Hotel.Managements.Project.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        Guest existingGuest = guestRepository.findById(id).orElse(null);
        if (existingGuest != null) {
            existingGuest.setFirstName(updatedGuest.getFirstName());
            existingGuest.setLastName(updatedGuest.getLastName());
            existingGuest.setEmail(updatedGuest.getEmail());
            existingGuest.setPhoneNumber(updatedGuest.getPhoneNumber());
            existingGuest.setAddress(updatedGuest.getAddress());
            existingGuest.setNationality(updatedGuest.getNationality());
            existingGuest.setIdentificationNumber(updatedGuest.getIdentificationNumber());


            return guestRepository.save(existingGuest);
        }
        return null;
    }


    public boolean deleteGuest(Long id) {
        try {
            guestRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        } catch (Exception e) {

            return false;
        }
    }

}

