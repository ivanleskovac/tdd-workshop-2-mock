package com.vdarko.workshop.tdd.mock.example.impl;

import java.util.List;

import com.vdarko.workshop.tdd.mock.example.Service;

public class ServiceImplStaticMethod implements Service {

  @Override
  public List<String> findAll() {
    return RepositoryImplStaticMethod.findAllRecordsStatic();
  }
}
