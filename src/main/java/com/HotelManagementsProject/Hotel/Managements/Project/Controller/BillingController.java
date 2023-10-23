package com.HotelManagementsProject.Hotel.Managements.Project.Controller;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Billing;
import com.HotelManagementsProject.Hotel.Managements.Project.Service.BillingService;
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
    public ResponseEntity<Billing> createBilling(@RequestBody Billing billing) {
        Billing createdBilling = billingService.createBilling(billing);
        return new ResponseEntity<>(createdBilling, HttpStatus.CREATED);
    }

    @GetMapping("/{billingId}")
    public ResponseEntity<Billing> getBillingById(@PathVariable Long billingId) {
        Billing billing = billingService.getBillingById(billingId);
        if (billing != null) {
            return new ResponseEntity<>(billing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Billing>> getAllBillings() {
        List<Billing> billings = billingService.getAllBillings();
        return new ResponseEntity<>(billings, HttpStatus.OK);
    }

    @PutMapping("/update/{billingId}")
    public ResponseEntity<Billing> updateBilling(@PathVariable Long billingId, @RequestBody Billing updatedBilling) {
        Billing billing = billingService.updateBilling(billingId, updatedBilling);
        if (billing != null) {
            return new ResponseEntity<>(billing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{billingId}")
    public ResponseEntity<Void> deleteBilling(@PathVariable Long billingId) {
        billingService.deleteBilling(billingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

