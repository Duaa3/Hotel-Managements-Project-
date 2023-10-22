package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Room {
@Id
    private String roomNumber;
    private double rate;
    private String roomType;

    public Room(String roomNumber, double rate, String standard) {
    }

    public Room() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Double.compare(rate, room.rate) == 0 && Objects.equals(roomNumber, room.roomNumber) && Objects.equals(roomType, room.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, rate, roomType);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", rate=" + rate +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
