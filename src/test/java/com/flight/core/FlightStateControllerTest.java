package com.flight.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FlightStateControllerTest {

  private FlightStateController flightStateController;

  @BeforeEach
  public void before() {
    flightStateController = FlightStateController.getInstance();
  }

  @Test
  public void test_flightState() {
    Assertions.assertEquals(FlightState.IDLE, flightStateController.getFlightState());
    flightStateController.setFlightState(FlightState.INITIALIZATION);
    Assertions.assertEquals(FlightState.INITIALIZATION, flightStateController.getFlightState());
  }

}