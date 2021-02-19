package com.vdarko.workshop.tdd.mock.car.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.vdarko.workshop.tdd.mock.car.model.SparePart;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarRepairResponse {
  private LocalDate serviceDate;
  private List<SparePart> replacedSpareParts;
  private BigDecimal totalPrice;
}
