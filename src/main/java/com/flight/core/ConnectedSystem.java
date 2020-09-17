package com.flight.core;

public abstract class ConnectedSystem {

  private final String systemName;

  public ConnectedSystem(String systemName) {
    this.systemName = systemName;
  }

  public String getSystemName() {
    return systemName;
  }

  abstract public String getData();
}
