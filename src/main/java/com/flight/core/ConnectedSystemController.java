package com.flight.core;

import java.util.ArrayList;
import java.util.List;

public class ConnectedSystemController {

  private final List<ConnectedSystem> connectedSystems;

  public ConnectedSystemController() {
    connectedSystems = new ArrayList<>();
  }

  public void addConnectedSystem(ConnectedSystem system) {
    connectedSystems.add(system);
  }

  public List<ConnectedSystem> getConnectedSystems() {
    return connectedSystems;
  }

}
