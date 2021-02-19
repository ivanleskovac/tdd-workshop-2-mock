package com.vdarko.workshop.tdd.mock.car.model.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.vdarko.workshop.tdd.mock.car.dto.CarRepairRequest;
import com.vdarko.workshop.tdd.mock.car.dto.CarRepairResponse;
import com.vdarko.workshop.tdd.mock.car.model.SparePart;
import com.vdarko.workshop.tdd.mock.car.model.SparePartsAvailability;
import com.vdarko.workshop.tdd.mock.car.model.service.CarService;
import com.vdarko.workshop.tdd.mock.car.model.service.CarServiceException;
import com.vdarko.workshop.tdd.mock.car.model.service.ManufacturerInstructionsService;
import com.vdarko.workshop.tdd.mock.car.model.service.SparePartsService;

public class CarServiceImpl implements CarService {

  private ManufacturerInstructionsService manufacturerInstructionsService;
  private SparePartsService sparePartsService;

  /**
   * All arguments constructor used for injecting (auto-wiring) used components
   *
   * @param manufacturerInstructionsService manufacturer instructions service
   * @param sparePartsService               spare parts service
   */
  public CarServiceImpl(ManufacturerInstructionsService manufacturerInstructionsService, SparePartsService sparePartsService) {
    this.manufacturerInstructionsService = manufacturerInstructionsService;
    this.sparePartsService = sparePartsService;
  }

  @Override
  public CarRepairResponse repair(CarRepairRequest request) {
    List<SparePart> spareParts = manufacturerInstructionsService.getSparePartsForReplacement(request.getVehicleIdentificationNumber(),
            request.getRegularServiceType(), request.getMileageInKm());
    List<SparePartsAvailability> sparePartAvailabilities = sparePartsService.getAvailabilities(spareParts);

    validateSparePartAvailability(sparePartAvailabilities);

    BigDecimal totalPrice = calculateTotalPrice(spareParts);

    return CarRepairResponse.builder()//
            .replacedSpareParts(spareParts)//
            .totalPrice(totalPrice)//
            .serviceDate(LocalDate.now())//
            .build();
  }

  private void validateSparePartAvailability(List<SparePartsAvailability> sparePartAvailabilities) {
    List<Long> unavailableSpareParts = sparePartAvailabilities.stream()//
            .filter(sparePartsAvailability -> !sparePartsAvailability.getAvailable())//
            .map(SparePartsAvailability::getSparePartId)//
            .collect(Collectors.toList());

    if (!unavailableSpareParts.isEmpty()) {
      String unavailableSparePartIds = unavailableSpareParts.stream()//
              .map(Object::toString)//
              .collect(Collectors.joining(","));
      throw new CarServiceException("Car could not be repaired since following spare parts"//
              + " are not on the stock: " + unavailableSparePartIds);
    }
  }

  private BigDecimal calculateTotalPrice(List<SparePart> spareParts) {
    return spareParts.stream()//
            .map(SparePart::getPrice)//
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
