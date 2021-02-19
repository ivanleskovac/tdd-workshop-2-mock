package com.vdarko.workshop.tdd.mock.example.impl;

import java.util.List;

import com.vdarko.workshop.tdd.mock.example.Repository;
import com.vdarko.workshop.tdd.mock.example.Service;

public class ServiceImplCdi implements Service {

  private Repository repository;

  public ServiceImplCdi(Repository repository) {
    this.repository = repository;
  }

  @Override
  public List<String> findAll() {
    return repository.findAllRecords();
  }
}
