package com.flight;


import com.flight.core.FlightState;
import com.flight.core.FlightStateController;
import com.flight.core.FlightVehicleInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightSysController {

  @RequestMapping("/")
  public String info() {
    return FlightVehicleInfo.getInstance().toString();
  }

  @RequestMapping("/state")
  public FlightState state() {
    return FlightStateController.getInstance().getFlightState();
  }
}
