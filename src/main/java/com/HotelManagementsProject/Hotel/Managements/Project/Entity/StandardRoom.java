package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import jakarta.persistence.Entity;

@Entity
public class StandardRoom extends Room {
    public StandardRoom() {
    }

    public StandardRoom(String roomNumber, double rate, boolean available) {
        super(roomNumber, rate, "Standard", available);
    }
}
