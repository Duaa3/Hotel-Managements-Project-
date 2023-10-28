package com.HotelManagementsProject.Hotel.Managements.Project.Controller;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Staff;
import com.HotelManagementsProject.Hotel.Managements.Project.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    /**
     * Create a new staff member.
     *
     * @param staff The staff object to be created.
     * @return A response indicating the success or failure of the creation.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createStaff(@RequestBody Staff staff) {
        try {
            Staff createdStaff = staffService.createStaff(staff);
            String message = "Staff created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            String errorMessage = "Staff not created: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /**
     * Update a staff member by their ID.
     *
     * @param staffId       The ID of the staff member to update.
     * @param updatedStaff  The updated staff member object.
     * @return A response indicating the success or failure of the update.
     */
    @PutMapping("/update/{staffId}")
    public ResponseEntity<String> updateStaff(@PathVariable Long staffId, @RequestBody Staff updatedStaff) {
        try {
            Staff staff = staffService.updateStaff(staffId, updatedStaff);
            if (staff != null) {
                String message = "Staff updated successfully";
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } else {
                String errorMessage = "Staff not found with ID: " + staffId;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Staff update failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /**
     * Retrieve a staff member by their ID.
     *
     * @param staffId The ID of the staff member to retrieve.
     * @return A response containing the staff member information or an error message.
     */
    @GetMapping("/{staffId}")
    public ResponseEntity<String> getStaffById(@PathVariable Long staffId) {
        Staff staff = staffService.getStaffById(staffId);
        if (staff != null) {
            return ResponseEntity.status(HttpStatus.OK).body(staff.toString());
        } else {
            String errorMessage = "Staff not found with ID: " + staffId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    /**
     * Retrieve a list of all staff members.
     *
     * @return A response containing a list of staff member entries or an error message.
     */
    @GetMapping("/all")
    public ResponseEntity<String> getAllStaff() {
        List<Staff> staffList = staffService.getAllStaff();
        return ResponseEntity.status(HttpStatus.OK).body(staffList.toString());
    }

    /**
     * Delete a staff member by their ID.
     *
     * @param staffId The ID of the staff member to delete.
     * @return A response indicating the success or failure of the deletion.
     */
    @DeleteMapping("/delete/{staffId}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long staffId) {
        try {
            staffService.deleteStaff(staffId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Staff deleted successfully");
        } catch (Exception e) {
            String errorMessage = "Staff delete failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
}
