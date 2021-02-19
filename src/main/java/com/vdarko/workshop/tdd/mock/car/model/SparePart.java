package com.vdarko.workshop.tdd.mock.car.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SparePart {
  private Long id;
  private String manufacturerName;
  private BigDecimal price; // prices are in default currency (euro)
}
