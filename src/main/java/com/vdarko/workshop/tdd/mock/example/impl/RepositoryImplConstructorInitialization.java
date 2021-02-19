package com.vdarko.workshop.tdd.mock.example.impl;

import java.util.Arrays;
import java.util.List;

import com.vdarko.workshop.tdd.mock.example.Repository;

public class RepositoryImplConstructorInitialization implements Repository{

  public RepositoryImplConstructorInitialization() {
    throw new RuntimeException("Could not obtain database connection");
  }

  @Override
  public List<String> findAllRecords() {
    return Arrays.asList("1", "2", "3");
  }
}
