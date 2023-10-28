package com.HotelManagementsProject.Hotel.Managements.Project.Controller;


import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Room;
import com.HotelManagementsProject.Hotel.Managements.Project.Repository.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class RoomControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private RoomRepository roomRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Room room1 = new Room("101", 100.0, "Standard", true);
        Room room2 = new Room("102", 150.0, "Deluxe", false);
        roomRepository.saveAll(List.of(room1, room2));
    }

    @Test
    void createRoomTest() throws Exception {
        Room newRoom = new Room("103", 120.0, "Standard", true);
        String requestBody = objectMapper.writeValueAsString(newRoom);

        mockMvc.perform(MockMvcRequestBuilders.post("/rooms/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("Room created successfully"));
    }

    @Test
    void updateRoomTest() throws Exception {
        Room updatedRoom = new Room("101", 110.0, "Standard", true);
        String requestBody = objectMapper.writeValueAsString(updatedRoom);

        mockMvc.perform(MockMvcRequestBuilders.put("/rooms/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Room updated successfully"));
    }

    @Test
    void getRoomByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rooms/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"roomNumber\":\"101\",\"rate\":100.0,\"roomType\":\"Standard\",\"available\":true}"));
    }

    @Test
    void getAllRoomsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rooms/all"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"roomNumber\":\"101\",\"rate\":100.0,\"roomType\":\"Standard\",\"available\":true}," +
                        "{\"roomNumber\":\"102\",\"rate\":150.0,\"roomType\":\"Deluxe\",\"available\":false}]"));
    }

    @Test
    void getAvailableRoomsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rooms/available"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"roomNumber\":\"101\",\"rate\":100.0,\"roomType\":\"Standard\",\"available\":true}]"));
    }

    @Test
    void deleteRoomTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/rooms/delete/1"))
                .andExpect(status().isNoContent());
    }
}
