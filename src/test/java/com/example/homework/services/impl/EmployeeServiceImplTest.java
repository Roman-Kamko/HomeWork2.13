package com.example.homework.services.impl;

import com.example.homework.model.Employee;
import com.example.homework.services.ValidatorService;
import constants.EmployeeServiceConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static constants.EmployeeServiceConstants.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private ValidatorService validatorMock;
    // без этого не пашет тест shouldReturnCollectionOfEmployeeWhenGetEmployeesCalled,
    // ругается что ValidatorService is null)
    @InjectMocks
    private EmployeeServiceImpl out;

    @Test
    void shouldReturnCollectionOfEmployeeWhenGetEmployeesCalled() {
        out.add("Qqqq", "Qqqq", "10000", 1);
        out.add("Wwww", "Wwww", "11000", 1);
        out.add("Eeee", "Eeee", "12000", 2);
        out.add("Rrrr", "Rrrr", "13000", 3);

        Collection<Employee> expected = out.printAll();

        Assertions.assertThat(EMP_LIST).containsExactlyInAnyOrderElementsOf(expected);
    }

}