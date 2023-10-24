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


    @GetMapping("/all")
    public ResponseEntity<Object> getAllBillings() {
        List<Billing> billings = billingService.getAllBillings();
        return ResponseEntity.status(HttpStatus.OK).body(billings.toString());
    }

    @PutMapping("/update/{billingId}")
    public ResponseEntity<String> updateBilling(@PathVariable Long billingId, @RequestBody Billing updatedBilling) {

            try{
                billingService.updateBilling(billingId, updatedBilling);
                String message = "Updated Successfully";
                return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            String errorMessage = "Billing update failed"+e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }


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
