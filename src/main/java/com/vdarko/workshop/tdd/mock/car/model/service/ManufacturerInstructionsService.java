package com.vdarko.workshop.tdd.mock.car.model.service;

import java.util.List;

import com.vdarko.workshop.tdd.mock.car.model.RegularServiceType;
import com.vdarko.workshop.tdd.mock.car.model.SparePart;

public interface ManufacturerInstructionsService {

  List<SparePart> getSparePartsForReplacement(String vehicleIdentificationNumber, RegularServiceType regularServiceType, Integer mileageInKm);
}
