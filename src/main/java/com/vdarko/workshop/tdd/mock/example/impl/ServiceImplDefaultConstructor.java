package com.vdarko.workshop.tdd.mock.example.impl;

import java.util.List;

import com.vdarko.workshop.tdd.mock.example.Repository;
import com.vdarko.workshop.tdd.mock.example.Service;

public class ServiceImplDefaultConstructor implements Service {

  private Repository repository;

  public ServiceImplDefaultConstructor() {
    this.repository = new RepositoryImplConstructorInitialization();
  }

  @Override
  public List<String> findAll() {
    return repository.findAllRecords();
  }
}
