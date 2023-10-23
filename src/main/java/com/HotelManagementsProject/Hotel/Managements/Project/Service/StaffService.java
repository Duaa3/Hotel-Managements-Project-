package com.HotelManagementsProject.Hotel.Managements.Project.Service;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Staff;
import com.HotelManagementsProject.Hotel.Managements.Project.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        return staffRepository.save(updatedStaff);
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}
