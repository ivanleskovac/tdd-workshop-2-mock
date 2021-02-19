package com.vdarko.workshop.tdd.mock.car.model.service;

import java.util.List;

import com.vdarko.workshop.tdd.mock.car.model.SparePart;
import com.vdarko.workshop.tdd.mock.car.model.SparePartsAvailability;

public interface SparePartsService {

  List<SparePartsAvailability> getAvailabilities(List<SparePart> spareParts);
}
