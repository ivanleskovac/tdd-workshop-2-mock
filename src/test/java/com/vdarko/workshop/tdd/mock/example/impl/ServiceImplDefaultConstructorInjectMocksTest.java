package com.vdarko.workshop.tdd.mock.example.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vdarko.workshop.tdd.mock.example.Repository;

@ExtendWith(MockitoExtension.class)
public class ServiceImplDefaultConstructorInjectMocksTest {

  @Mock
  private Repository repository;

  @InjectMocks
  // avoid constructor call and instantiate object using reflection
  private ServiceImplDefaultConstructor service = mock(ServiceImplDefaultConstructor.class, CALLS_REAL_METHODS);

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
    when(repository.findAllRecords()).thenReturn(records);

    List<String> results = service.findAll();

    // THEN
    assertThat(results).isNotNull()//
    .containsExactlyElementsOf(records);
  }
}
