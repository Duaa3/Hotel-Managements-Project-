package com.HotelManagementsProject.Hotel.Managements.Project.Controller;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Billing;
import com.HotelManagementsProject.Hotel.Managements.Project.Service.BillingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/billings")
public class BillingController {

    @Autowired
    private BillingService billingService;

    /**
     * Create a new billing entry.
     *
     * @param billing The billing object to be created.
     * @return A response indicating the success or failure of the creation.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createBilling(@RequestBody @Valid Billing billing) {
        try {
            Billing createdBilling = billingService.createBilling(billing);
            String message = "Added Successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            String errorMessage = "Billing not created: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /**
     * Retrieve a billing entry by its ID.
     *
     * @param billingId The ID of the billing entry to retrieve.
     * @return A response containing the billing information or an error message.
     */
    @GetMapping("/{billingId}")
    public ResponseEntity<Object> getBillingById(@PathVariable Long billingId) {
        Billing billing = billingService.getBillingById(billingId);
        if (billing != null) {
            return ResponseEntity.status(HttpStatus.OK).body(billing.toString());
        } else {
            String errorMessage = "Billing not found with ID: " + billingId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    /**
     * Retrieve a list of all billing entries.
     *
     * @return A response containing a list of billing entries or an error message.
     */
    @GetMapping("/all")
    public ResponseEntity<Object> getAllBillings() {
        List<Billing> billings = billingService.getAllBillings();
        return ResponseEntity.status(HttpStatus.OK).body(billings.toString());
    }

    /**
     * Update a billing entry by its ID.
     *
     * @param billingId     The ID of the billing entry to update.
     * @param updatedBilling The updated billing object.
     * @return A response indicating the success or failure of the update.
     */
    @PutMapping("/update/{billingId}")
    public ResponseEntity<String> updateBilling(@PathVariable Long billingId, @RequestBody Billing updatedBilling) {

        try {
            billingService.updateBilling(billingId, updatedBilling);
            String message = "Updated Successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            String errorMessage = "Billing update failed" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /**
     * Delete a billing entry by its ID.
     *
     * @param billingId The ID of the billing entry to delete.
     * @return A response indicating the success or failure of the deletion.
     */
    @DeleteMapping("/delete/{billingId}")
    public ResponseEntity<String> deleteBilling(@PathVariable String billingId) {
        try {
            Long id = Long.parseLong(billingId);
            billingService.deleteBilling(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Billing deleted successfully");
        } catch (NumberFormatException e) {
            String errorMessage = "Invalid billing ID format: " + billingId;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        } catch (Exception e) {
            String errorMessage = "Billing delete failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
}
