package com.HotelManagementsProject.Hotel.Managements.Project.Entity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;


public class BillingTest {


    // Creating a new instance of Billing with valid parameters should set the attributes correctly.
    @Test
    public void test_create_instance_with_valid_parameters() {
        Billing billing = new Billing(1L, "Paid", "Credit Card");
        assertEquals(1L, billing.getId().longValue());
        assertEquals("Paid", billing.getPaymentStatus());
        assertEquals("Credit Card", billing.getPaymentMethod());
    }

    // getId() should return the correct id.
    @Test
    public void test_get_id() {
        Billing billing = new Billing(1L, "Paid", "Credit Card");
        assertEquals(1L, billing.getId().longValue());
    }

    // getPaymentStatus() should return the correct payment status.
    @Test
    public void test_get_payment_status() {
        Billing billing = new Billing(1L, "Paid", "Credit Card");
        assertEquals("Paid", billing.getPaymentStatus());
    }



    // getId() should return null if the id has not been set.
    @Test
    public void test_get_id_null() {
        Billing billing = new Billing();
        assertNull(billing.getId());
    }

}