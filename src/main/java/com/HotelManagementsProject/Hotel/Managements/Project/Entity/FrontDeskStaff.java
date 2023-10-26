package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import jakarta.persistence.Entity;

@Entity
public class FrontDeskStaff extends Staff {
    public FrontDeskStaff() {

    }

    public FrontDeskStaff(Long staffID, String firstName, String lastName, String email) {
        super(staffID, firstName, lastName, email, "Front Desk Staff");
    }
}
