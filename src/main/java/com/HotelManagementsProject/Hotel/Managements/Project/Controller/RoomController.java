package com.HotelManagementsProject.Hotel.Managements.Project.Controller;

import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Room;
import com.HotelManagementsProject.Hotel.Managements.Project.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<String> createRoom(@RequestBody Room room) {
        try {
            Room createdRoom = roomService.createRoom(room);
            String message = "Room created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            String errorMessage = "Room not created: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @PutMapping("/update/{roomId}")
    public ResponseEntity<String> updateRoom(@PathVariable Long roomId, @RequestBody Room updatedRoom) {
        try {
            Room room = roomService.updateRoom(roomId, updatedRoom);
            if (room != null) {
                String message = "Room updated successfully";
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } else {
                String errorMessage = "Room not found with ID: " + roomId;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Room update failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<String> getRoomById(@PathVariable Long roomId) {
        Room room = roomService.getRoomById(roomId);
        if (room != null) {
            return ResponseEntity.status(HttpStatus.OK).body(room.toString());
        } else {
            String errorMessage = "Room not found with ID: " + roomId;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.status(HttpStatus.OK).body(rooms.toString());
    }

    @GetMapping("/available")
    public ResponseEntity<String> getAvailableRooms() {
        List<Room> availableRooms = roomService.getAvailableRooms();
        return ResponseEntity.status(HttpStatus.OK).body(availableRooms.toString());
    }

    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long roomId) {
        try {
            roomService.deleteRoom(roomId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Room deleted successfully");
        } catch (Exception e) {
            String errorMessage = "Room delete failed: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
}

