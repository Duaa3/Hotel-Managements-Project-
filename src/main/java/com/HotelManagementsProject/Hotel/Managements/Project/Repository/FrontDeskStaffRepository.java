package com.HotelManagementsProject.Hotel.Managements.Project.Repository;


import com.HotelManagementsProject.Hotel.Managements.Project.Entity.FrontDeskStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontDeskStaffRepository extends JpaRepository<FrontDeskStaff, Long> {

}
