package com.vdarko.workshop.tdd.mock.car.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SparePartsAvailability {
  private Long sparePartId;
  private BigDecimal price;
  private Boolean available;
}
