package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import jakarta.persistence.Entity;

@Entity
public class Manager extends Staff {
    public Manager() {

    }

    public Manager(Long staffID, String firstName, String lastName, String email) {
        super(staffID, firstName, lastName, email, "Manager");
    }
}
