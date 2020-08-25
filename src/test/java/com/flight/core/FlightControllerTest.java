package com.flight.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class FlightControllerTest {

  private FlightController flightController;

  @Autowired
  private ConnectedSystemController connectedSystemController;

  @BeforeEach
  public void before() {
    flightController = new FlightController(connectedSystemController);
  }

  @Test
  public void test_flightState() {
    Assertions.assertEquals(FlightState.IDLE, flightController.getFlightState());
    flightController.setFlightState(FlightState.INITIALIZATION);
    Assertions.assertEquals(FlightState.INITIALIZATION, flightController.getFlightState());
  }

}
