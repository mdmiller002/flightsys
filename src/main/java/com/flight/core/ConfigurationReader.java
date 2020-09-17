package com.flight.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class ConfigurationReader {

  private static final Logger LOG = LoggerFactory.getLogger(ConfigurationReader.class);

  private final String configFileName;
  private String vehicleName;
  private String vehicleVersion;

  public ConfigurationReader(String configFileName) {
    this.configFileName = configFileName;
  }

  public String getVehicleVersion() {
    if (vehicleVersion == null) {
      readConfig();
    }
    return vehicleVersion;
  }

  public String getVehicleName() {
    if (vehicleVersion == null) {
      readConfig();
    }
    return vehicleName;
  }

  // FUTURE: Allow reading the config from a more generic location, not just on the classpath.
  // Allow the user to specify a config location on startup and if that exists, take
  // the config from there
  public void readConfig() {
    Yaml yaml = new Yaml();
    try {
      ClassPathResource classPathResource = new ClassPathResource(configFileName);
      LOG.info("Reading config from file in classpath: " + classPathResource.getPath());
      InputStream inputStream = classPathResource.getInputStream();
      Map<String, Object> configMap = yaml.load(inputStream);
      vehicleName = (String) configMap.getOrDefault("name", "");
      vehicleVersion = configMap.getOrDefault("version", "").toString();
    } catch (IOException e) {
      LOG.error("Specified config file " + configFileName + " could not be read: ", e);
      vehicleName = "";
      vehicleVersion = "";
    }
  }
}
