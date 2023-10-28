package com.HotelManagementsProject.Hotel.Managements.Project.Service;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Hotel;
import com.HotelManagementsProject.Hotel.Managements.Project.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        return hotelRepository.save(updatedHotel);
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }


}
