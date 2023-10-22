package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import jakarta.persistence.Entity;

@Entity
public class HousekeepingStaff extends Staff {
    public HousekeepingStaff() {
        // Default constructor
    }

    public HousekeepingStaff(Long staffID, String firstName, String lastName, String email) {
        super(staffID, firstName, lastName, email, "Housekeeping Staff");
    }
}
