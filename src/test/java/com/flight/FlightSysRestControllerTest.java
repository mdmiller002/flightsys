package com.flight;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FlightSysRestControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void testGetRoot() throws Exception {
    doTest("/", "APOLLO V11");
  }

  @Test
  public void testGetState() throws Exception {
    doTest("/state", "IDLE");
  }

  @Test
  public void testGetInfo() throws Exception {
    String expected = "{\"flightState\":\"IDLE\"," +
        "\"connectedSystemsNames\":[],\"flightVehicleInfo\":" +
        "{\"vehicleName\":\"APOLLO\",\"vehicleVersion\":\"11\"}}";
    doTest("/info", expected);
  }

  private void doTest(String endpoint, String expected) throws Exception {
    mvc.perform(MockMvcRequestBuilders.get(endpoint).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo(expected)));
  }

}