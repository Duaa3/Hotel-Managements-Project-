package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import jakarta.persistence.Entity;

@Entity
public class Suite extends Room {
    public Suite() {
    }

    public Suite(String roomNumber, double rate) {
        super(roomNumber, rate, "Suite");
    }
}
