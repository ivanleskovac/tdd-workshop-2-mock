package com.vdarko.workshop.tdd.mock.car.dto;

import com.vdarko.workshop.tdd.mock.car.model.RegularServiceType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarRepairRequest {
  private String vehicleIdentificationNumber;
  private RegularServiceType regularServiceType;
  private Integer mileageInKm;
  private String customerInputs;
}
