package com.flight.core;

public class VehicleInfo {

  private final String vehicleName;
  private final String vehicleVersion;

  public VehicleInfo(String vehicleName, String vehicleVersion) {
    this.vehicleName = vehicleName;
    this.vehicleVersion = vehicleVersion;
  }

  @Override
  public String toString() {
    return vehicleName + " V" + vehicleVersion;
  }

  public String getVehicleName() {
    return vehicleName;
  }

  public String getVehicleVersion() {
    return vehicleVersion;
  }
}
