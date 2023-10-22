package com.HotelManagementsProject.Hotel.Managements.Project.Repository;


import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

}
