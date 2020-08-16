package com.flight.core;

public class FlightVehicleInfo {

  private static FlightVehicleInfo flightVehicleInfo;

  private final String vehicleName;
  private final String vehicleVersion;

  private FlightVehicleInfo(String vehicleName, String vehicleVersion) {
    this.vehicleName = vehicleName;
    this.vehicleVersion = vehicleVersion;
  }

  public static FlightVehicleInfo getInstance() {
    if (flightVehicleInfo == null) {
      flightVehicleInfo = readFlightVehicleInfo();
    }
    return flightVehicleInfo;
  }

  private static FlightVehicleInfo readFlightVehicleInfo() {
    // TODO implement me
    String name = "APOLLO";
    String version = "11";
    return new FlightVehicleInfo(name, version);
  }

  @Override
  public String toString() {
    return "Flight Vehicle Info: " + vehicleName + " V" + vehicleVersion;
  }
}
