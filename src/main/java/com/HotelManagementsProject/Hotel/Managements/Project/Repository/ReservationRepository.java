package com.HotelManagementsProject.Hotel.Managements.Project.Repository;


import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
