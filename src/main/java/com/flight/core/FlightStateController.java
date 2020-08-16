package com.flight.core;

public class FlightStateController {

  private static FlightStateController instance;

  private FlightState flightState;

  private FlightStateController() {
    flightState = FlightState.IDLE;
  }

  public static FlightStateController getInstance() {
    if (instance == null) {
      instance = new FlightStateController();
    }
    return instance;
  }

  public FlightState getFlightState() {
    return flightState;
  }

  public void setFlightState(FlightState flightState) {
    this.flightState = flightState;
  }
}
