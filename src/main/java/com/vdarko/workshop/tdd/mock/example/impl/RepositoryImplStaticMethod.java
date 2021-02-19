package com.vdarko.workshop.tdd.mock.example.impl;

import java.util.Arrays;
import java.util.List;

public class RepositoryImplStaticMethod {

  public static List<String> findAllRecordsStatic() {
    return Arrays.asList("1", "2", "3");
  }
}
