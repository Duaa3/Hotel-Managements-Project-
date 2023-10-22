package com.HotelManagementsProject.Hotel.Managements.Project.Repository;


import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}

