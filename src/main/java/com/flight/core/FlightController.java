package com.flight.core;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * FlightController is the central controlling class for the flight.
 * FlightController is the top-level controller for flight
 * state and operations.
 */
public class FlightController {

  private final ConnectedSystemController connectedSystemController;

  private VehicleInfo vehicleInfo;
  private FlightState flightState;

  @Autowired
  private ConfigurationReader configurationReader;

  public FlightController(ConnectedSystemController connectedSystemController) {
    this.flightState = FlightState.IDLE;
    this.connectedSystemController = connectedSystemController;
  }

  public FlightState getFlightState() {
    return flightState;
  }

  public void setFlightState(FlightState flightState) {
    this.flightState = flightState;
  }

  public VehicleInfo getVehicleInfo() {
    if (vehicleInfo == null) {
      this.vehicleInfo = readVehicleInfo();
    }
    return vehicleInfo;
  }

  public SystemMetadata getSystemMetadata() {
    if (vehicleInfo == null) {
      this.vehicleInfo = readVehicleInfo();
    }
    return new SystemMetadata(flightState, vehicleInfo, connectedSystemController);
  }

  private VehicleInfo readVehicleInfo() {
    return new VehicleInfo(configurationReader.getVehicleName(),
        configurationReader.getVehicleVersion());
  }
}
