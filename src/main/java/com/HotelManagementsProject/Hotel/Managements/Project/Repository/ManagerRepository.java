package com.HotelManagementsProject.Hotel.Managements.Project.Repository;


import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
