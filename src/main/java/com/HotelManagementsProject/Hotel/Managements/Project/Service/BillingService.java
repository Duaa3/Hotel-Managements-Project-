package com.HotelManagementsProject.Hotel.Managements.Project.Service;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Billing;
import com.HotelManagementsProject.Hotel.Managements.Project.Repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public Billing getBillingById(Long id) {
        return billingRepository.findById(id).orElse(null);
    }

    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    public Billing updateBilling(Long id, Billing updatedBilling) {
        Billing existingBilling = billingRepository.findById(id).orElse(null);
        if (existingBilling != null) {
            existingBilling.setPaymentStatus(updatedBilling.getPaymentStatus());
            existingBilling.setPaymentMethod(updatedBilling.getPaymentMethod());


            return billingRepository.save(existingBilling);
        }
        return null;
    }

    public void deleteBilling(Long id) {
        billingRepository.deleteById(id);
    }
}

