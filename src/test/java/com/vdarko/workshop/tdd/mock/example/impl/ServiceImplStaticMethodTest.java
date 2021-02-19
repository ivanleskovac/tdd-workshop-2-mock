package com.vdarko.workshop.tdd.mock.example.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ServiceImplStaticMethodTest {

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
    try (MockedStatic<RepositoryImplStaticMethod> repositoryImplMockedStatic = Mockito.mockStatic(RepositoryImplStaticMethod.class)) {

      repositoryImplMockedStatic.when(RepositoryImplStaticMethod::findAllRecordsStatic).thenReturn(records);

      ServiceImplStaticMethod service = new ServiceImplStaticMethod();
      List<String> results = service.findAll();

      // THEN
      assertThat(results).isNotNull()//
      .containsExactlyElementsOf(records);
    }
  }
}
