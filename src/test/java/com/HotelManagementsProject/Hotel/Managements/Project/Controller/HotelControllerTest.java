package com.HotelManagementsProject.Hotel.Managements.Project.Controller;
import com.HotelManagementsProject.Hotel.Managements.Project.Entity.Hotel;
import com.HotelManagementsProject.Hotel.Managements.Project.Repository.HotelRepository;
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
class HotelControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private HotelRepository hotelRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Hotel hotel1 = new Hotel("Hotel A", "Address A", "City A");
        Hotel hotel2 = new Hotel("Hotel B", "Address B", "City B");
        hotelRepository.saveAll(List.of(hotel1, hotel2));
    }

    @Test
    void createHotelTest() throws Exception {
        Hotel newHotel = new Hotel("Hotel C", "Address C", "City C");
        String requestBody = objectMapper.writeValueAsString(newHotel);

        mockMvc.perform(MockMvcRequestBuilders.post("/hotels/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().string("Hotel added successfully"));
    }

    @Test
    void updateHotelTest() throws Exception {
        Hotel updatedHotel = new Hotel("Hotel A", "Updated Address", "Updated City");
        String requestBody = objectMapper.writeValueAsString(updatedHotel);

        mockMvc.perform(MockMvcRequestBuilders.put("/hotels/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Hotel updated successfully"));
    }

    @Test
    void getHotelByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hotels/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"name\":\"Hotel A\",\"address\":\"Address A\",\"city\":\"City A\"}"));
    }

    @Test
    void getAllHotelsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hotels/all"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"name\":\"Hotel A\",\"address\":\"Address A\",\"city\":\"City A\"}," +
                        "{\"name\":\"Hotel B\",\"address\":\"Address B\",\"city\":\"City B\"}]"));
    }

    @Test
    void deleteHotelTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/hotels/delete/1"))
                .andExpect(status().isNoContent());
    }
}
