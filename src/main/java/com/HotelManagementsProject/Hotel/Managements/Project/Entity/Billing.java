package com.HotelManagementsProject.Hotel.Managements.Project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentStatus;
    private String paymentMethod;

    public Billing() {
    }

    public Billing(Long id, String paymentStatus, String paymentMethod) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billing billing = (Billing) o;
        return Objects.equals(id, billing.id) && Objects.equals(paymentStatus, billing.paymentStatus) && Objects.equals(paymentMethod, billing.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentStatus, paymentMethod);
    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
