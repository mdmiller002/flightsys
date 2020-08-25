package com.flight.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreSpringConfig {

  @Bean
  public ConfigurationReader configurationReader() {
    // TODO fixme by getting actual filename
    String filename = "test-config.yml";
    return new ConfigurationReader(filename);
  }

  @Bean
  public FlightController flightController(ConnectedSystemController connectedSystemController) {
    return new FlightController(connectedSystemController);
  }

  @Bean
  public ConnectedSystemController connectedSystemController() {
    return new ConnectedSystemController();
  }


}
