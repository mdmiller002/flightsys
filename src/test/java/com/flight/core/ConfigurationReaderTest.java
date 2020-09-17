package com.flight.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConfigurationReaderTest {

  private static final String CONFIG_FILE = "test-config.yml";
  private ConfigurationReader configurationReader;

  @BeforeEach
  public void before() {
    configurationReader = new ConfigurationReader(CONFIG_FILE);
  }

  @Test
  public void testReadConfig() {
    configurationReader.readConfig();
    assertReadConfig();
  }

  @Test
  public void testConfigReads_JustCallGetVehicleName() {
    configurationReader.getVehicleName();
    assertReadConfig();
  }

  @Test
  public void testConfigReads_JustCallGetVehicleVersion() {
    configurationReader.getVehicleVersion();
    assertReadConfig();
  }

  private void assertReadConfig() {
    Assertions.assertEquals(configurationReader.getVehicleName(), "APOLLO");
    Assertions.assertEquals(configurationReader.getVehicleVersion(), "11");
  }

  @Test
  public void testConfigReads_InvalidFile() {
    configurationReader = new ConfigurationReader("INVALID_FILENAME.CSV");
    Assertions.assertEquals(configurationReader.getVehicleName(), "");
    Assertions.assertEquals(configurationReader.getVehicleVersion(), "");
  }

}