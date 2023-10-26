package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long staffID;

    private String firstName;
    private String lastName;
    private String email;
    private String role;

    public Staff() {
    }

    public Staff(Long staffID, String firstName, String lastName, String email, String role) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public Long getStaffID() {
        return staffID;
    }

    public void setStaffID(Long staffID) {
        this.staffID = staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(staffID, staff.staffID) && Objects.equals(firstName, staff.firstName) && Objects.equals(lastName, staff.lastName) && Objects.equals(email, staff.email) && Objects.equals(role, staff.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffID, firstName, lastName, email, role);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID=" + staffID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}


