package com.flight.core;

import java.util.List;
import java.util.stream.Collectors;

public class SystemMetadata {

  private final FlightState flightState;
  private final VehicleInfo vehicleInfo;
  private final List<String> connectedSystemsNames;

  public SystemMetadata(FlightState flightState, VehicleInfo vehicleInfo, ConnectedSystemController connectedSystemController) {
    this.flightState = flightState;
    this.vehicleInfo = vehicleInfo;
    this.connectedSystemsNames = connectedSystemController
        .getConnectedSystems()
        .stream()
        .map(ConnectedSystem::getSystemName)
        .collect(Collectors.toList());
  }

  public FlightState getFlightState() {
    return flightState;
  }

  public VehicleInfo getFlightVehicleInfo() {
    return vehicleInfo;
  }

  public List<String> getConnectedSystemsNames() {
    return connectedSystemsNames;
  }

}
