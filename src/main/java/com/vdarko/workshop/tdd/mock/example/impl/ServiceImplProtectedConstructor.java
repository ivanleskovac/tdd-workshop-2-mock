package com.vdarko.workshop.tdd.mock.example.impl;

import java.util.List;

import com.vdarko.workshop.tdd.mock.example.Repository;
import com.vdarko.workshop.tdd.mock.example.Service;

public class ServiceImplProtectedConstructor implements Service {

  private Repository repository;

  /**
   * Constructor used only in main classpath
   */
  public ServiceImplProtectedConstructor() {
    this.repository = new RepositoryImplConstructorInitialization();
  }

  /**
   * Constructor used only in test classpath
   *
   * @param repository repository
   */
  protected ServiceImplProtectedConstructor(Repository repository) {
    this.repository = repository;
  }

  @Override
  public List<String> findAll() {
    return repository.findAllRecords();
  }
}
