package com.vdarko.workshop.tdd.mock.car.model.service.impl;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import com.vdarko.workshop.tdd.mock.car.model.SparePart;
import com.vdarko.workshop.tdd.mock.car.model.SparePartsAvailability;
import com.vdarko.workshop.tdd.mock.car.model.service.CarServiceException;
import com.vdarko.workshop.tdd.mock.car.model.service.SparePartsService;

public class SparePartsServiceImpl implements SparePartsService {

  private static final String DISTRIBUTOR_URL = "http://spareparts.com/availability?%S";

  @Override
  public List<SparePartsAvailability> getAvailabilities(List<SparePart> spareParts) {
    try {
      URL url = new URL(DISTRIBUTOR_URL);
      url.openConnection();

      // returning empty list for now
      return Collections.emptyList();
    } catch (IOException e) {
      throw new CarServiceException("Could not get spare parts availabilities", e);
    }
  }
}
