package com.vdarko.workshop.tdd.mock.car.model.service;

import com.vdarko.workshop.tdd.mock.car.dto.CarRepairRequest;
import com.vdarko.workshop.tdd.mock.car.dto.CarRepairResponse;

public interface CarService {

  public CarRepairResponse repair(CarRepairRequest request);
}
