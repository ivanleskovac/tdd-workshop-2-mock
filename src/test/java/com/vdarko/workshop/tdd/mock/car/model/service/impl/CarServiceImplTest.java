package com.vdarko.workshop.tdd.mock.car.model.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.vdarko.workshop.tdd.mock.car.dto.CarRepairRequest;
import com.vdarko.workshop.tdd.mock.car.model.RegularServiceType;
import com.vdarko.workshop.tdd.mock.car.model.service.CarServiceException;
import com.vdarko.workshop.tdd.mock.car.model.service.ManufacturerInstructionsService;
import com.vdarko.workshop.tdd.mock.car.model.service.SparePartsService;

public class CarServiceImplTest {

  /**
   * <b>GIVEN</b> car repair request</br>
   * <b>AND</b> some parts that should be used in repair are not available</br>
   * <b>WHEN</b> car is repaired</br>
   * <b>THEN</b> exception with appropriate message is thrown</br>
   */
  @Test
  public void testSparePartsNotOnStock() {

    // GIVEN
    String vehicleIdentificationNumber = "theVehicleIdentificationNumber";
    RegularServiceType full = RegularServiceType.FULL;
    int mileageInKm = 1;
    String customerInputs = "any";

    @SuppressWarnings("unused")
    List<Long> sparePartsIdsForReplacement = Arrays.asList(1L, 2L, 3L);
    @SuppressWarnings("unused")
    List<Long> sparePartsIdsOnStock = Arrays.asList(1L);

    // WHEN
    CarRepairRequest request = CarRepairRequest.builder()//
            .vehicleIdentificationNumber(vehicleIdentificationNumber)//
            .regularServiceType(full)//
            .mileageInKm(mileageInKm)//
            .customerInputs(customerInputs)//
            .build();

    // TODO mock manufacturerInstructionsService
    ManufacturerInstructionsService manufacturerInstructionsService = null;
    // TODO mock sparePartsService
    SparePartsService sparePartsService = null;

    CarServiceImpl carService = new CarServiceImpl(manufacturerInstructionsService, sparePartsService);
    Throwable thrown = catchThrowable(() -> {//
      carService.repair(request);
    });

    // THEN
    assertThat(thrown).isNotNull()//
    .isInstanceOf(CarServiceException.class)//
    .hasMessage("Car could not be repaired since following spare parts"//
            + " are not on the stock: 2,3");
  }

  //TODO add test when spare parts are available
}
