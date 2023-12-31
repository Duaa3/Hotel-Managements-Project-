package com.HotelManagementsProject.Hotel.Managements.Project.Controller;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Reservation;
import com.HotelManagementsProject.Hotel.Managements.Project.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /**
     * Create a new reservation.
     *
     * @param reservation The reservation object to be created.
     * @return A response indicating the success or failure of the creation.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation) {
        try {
            Reservation createdReservation = reservationService.createReservation(reservation);
            String message = "Reservation created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            String errorMessage = "Reservation not created: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /**
     * Update a reservation by its ID.
     *
     * @param reservationId      The ID of the reservation to update.
     * @param updatedReservation The updated reservation object.
     * @return A response indicating the success or failure of the update.
     */
    @PutMapping("/update/{reservationId}")
    public ResponseEntity<String> updateReservation(@PathVariable Long reservationId, @RequestBody Reservation updatedReservation) {
        try {
            Reservation reservation = reservationService.updateReservation(reservationId, updatedReservation);
            if (reservation != null) {
                String message = "Reservation updated successfully";
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } else {
                String errorMessage = "Reservation not found with ID: " + reservationId;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Reservation update failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    /**
     * Retrieve a reservation by its ID.
     *
     * @param reservationId The ID of the reservation to retrieve.
     * @return A response containing the reservation information or an error message.
     */
    @GetMapping("/{reservationId}")
    public ResponseEntity<String> getReservationById(@PathVariable Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        if (reservation != null) {
            return ResponseEntity.status(HttpStatus.OK).body(reservation.toString());
        } else {
            String errorMessage = "Reservation not found with ID: " + reservationId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    /**
     * Retrieve a list of all reservations.
     *
     * @return A response containing a list of reservation entries or an error message.
     */
    @GetMapping("/all")
    public ResponseEntity<String> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.status(HttpStatus.OK).body(reservations.toString());
    }

    /**
     * Delete a reservation by its ID.
     *
     * @param reservationId The ID of the reservation to delete.
     * @return A response indicating the success or failure of the deletion.
     */
    @DeleteMapping("/delete/{reservationId}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long reservationId) {
        try {
            reservationService.deleteReservation(reservationId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Reservation deleted successfully");
        } catch (Exception e) {
            String errorMessage = "Reservation delete failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
}
