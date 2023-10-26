package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Room {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
    private String roomNumber;
    private double rate;
    private String roomType;
    @Column(name = "is_available")
    private boolean available;


    public Room() {
    }

    public Room(String roomNumber, double rate, String roomType, boolean available) {
        this.roomNumber = roomNumber;
        this.rate = rate;
        this.roomType = roomType;
        this.available = available;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Double.compare(rate, room.rate) == 0 && available == room.available && Objects.equals(roomNumber, room.roomNumber) && Objects.equals(roomType, room.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, rate, roomType, available);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", rate=" + rate +
                ", roomType='" + roomType + '\'' +
                ", available=" + available +
                '}';
    }
}
