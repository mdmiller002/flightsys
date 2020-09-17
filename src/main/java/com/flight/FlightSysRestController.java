package com.flight;

import com.flight.core.FlightController;
import com.flight.core.SystemMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightSysRestController {

  @Autowired
  private FlightController flightController;

  @RequestMapping("/")
  public String vehicleInfo() {
    return flightController.getVehicleInfo().toString();
  }

  @RequestMapping("/state")
  public String state() {
    return flightController.getFlightState().toString();
  }

  @RequestMapping("/info")
  public SystemMetadata flightInfo() {
    return flightController.getSystemMetadata();
  }
}
