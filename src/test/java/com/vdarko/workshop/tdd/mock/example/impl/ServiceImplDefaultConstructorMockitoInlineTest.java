package com.vdarko.workshop.tdd.mock.example.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

public class ServiceImplDefaultConstructorMockitoInlineTest {

  /**
   * <b>GIVEN</b> records repository contains records</br>
   * <b>WHEN</b> service finds all</br>
   * <b>THEN</b> result contains all records from repository</br>
   */
  @Test
  public void testRecordsExist() {

    // GIVEN
    List<String> records = Arrays.asList("A", "B", "C");

    // WHEN
    try (MockedConstruction<RepositoryImplConstructorInitialization> repositoryImplMockedConstruction = Mockito.mockConstruction(RepositoryImplConstructorInitialization.class)) {
      ServiceImplDefaultConstructor service = new ServiceImplDefaultConstructor();
      List<RepositoryImplConstructorInitialization> instances = repositoryImplMockedConstruction.constructed();
      RepositoryImplConstructorInitialization repository = instances.get(0);
      when(repository.findAllRecords()).thenReturn(records);

      List<String> results = service.findAll();

      // THEN
      assertThat(results).isNotNull()//
      .containsExactlyElementsOf(records);
    }
  }
}
