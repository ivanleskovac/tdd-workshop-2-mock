package com.vdarko.workshop.tdd.mock.car.model.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.vdarko.workshop.tdd.mock.car.model.RegularServiceType;
import com.vdarko.workshop.tdd.mock.car.model.SparePart;
import com.vdarko.workshop.tdd.mock.car.model.service.CarServiceException;
import com.vdarko.workshop.tdd.mock.car.model.service.ManufacturerInstructionsService;

public class ManufacturerInstructionsServiceImpl implements ManufacturerInstructionsService {

  private static final String DATASOURCE_JNDI_NAME = "java:comp/env/jdbc/Manufacturer";

  private DataSource datasource;

  public ManufacturerInstructionsServiceImpl() {
    try {
      datasource = (DataSource) new InitialContext().lookup(DATASOURCE_JNDI_NAME);
    } catch (NamingException e) {
      throw new CarServiceException("Could not obtain manufacturer datasource using jndi name=" + DATASOURCE_JNDI_NAME);
    }
  }

  @Override
  public List<SparePart> getSparePartsForReplacement(String vehicleIdentificationNumber, RegularServiceType regularServiceType,
          Integer mileageInKm) {
    try (Connection connection = datasource.getConnection()) {
      // selects records from the database

      // returning empty list for now
      return Collections.emptyList();
    } catch (SQLException e) {
      throw new CarServiceException("Could not get spare parts for replacement from the database", e);
    }
  }
}
