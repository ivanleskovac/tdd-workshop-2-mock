package com.vdarko.workshop.tdd.mock.example.impl;

import java.util.Arrays;
import java.util.List;

import com.vdarko.workshop.tdd.mock.example.Repository;

public class RepositoryImplStateless implements Repository{

  @Override
  public List<String> findAllRecords() {
    return Arrays.asList("1", "2", "3");
  }
}
