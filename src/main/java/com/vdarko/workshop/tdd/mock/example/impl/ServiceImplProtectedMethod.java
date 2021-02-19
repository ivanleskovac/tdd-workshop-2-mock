package com.vdarko.workshop.tdd.mock.example.impl;

import java.util.List;

import com.vdarko.workshop.tdd.mock.example.Repository;
import com.vdarko.workshop.tdd.mock.example.Service;

public class ServiceImplProtectedMethod implements Service {

  private Repository repository;

  public ServiceImplProtectedMethod() {
    this.repository = new RepositoryImplStateless();
  }

  @Override
  public List<String> findAll() {
    return getRepository().findAllRecords();
  }

  /**
   * Extracted for testing purposes.
   *
   * @return repository
   */
  protected Repository getRepository() {
    return repository;
  }
}
