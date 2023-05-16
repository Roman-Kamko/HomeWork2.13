package com.example.homework.services.impl;

import com.example.homework.exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static constants.DepartmentServiceConstants.*;
import static constants.EmployeeServiceConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void setUp() {
        Mockito.when(employeeMock.getEmployees()).thenReturn(EMP_LIST_1);
    }

    @Test
    void shouldReturnCorrectResultWhenFindMaxSalaryFromDepartmentCalled() {
        assertEquals(EMP_2, out.findMaxSalaryFromDepartment(DEP_1));
    }

    @Test
    void shouldThrowInvalidInputExceptionWhenFindMaxSalaryFromDepartmentCalled() {
        assertThrows(InvalidInputException.class, () -> out.findMaxSalaryFromDepartment(DEP_4));
        // haven't any employees in constants.EmployeeServiceConstants.EMP_LIST with department 4
    }

    @Test
    void shouldReturnCorrectResultWhenFindMinSalaryFromDepartmentCalled() {
        assertEquals(EMP_1, out.findMinSalaryFromDepartment(DEP_1));
    }

    @Test
    void shouldThrowInvalidInputExceptionWhenFindMinSalaryFromDepartmentCalled() {
        assertThrows(InvalidInputException.class, () -> out.findMinSalaryFromDepartment(DEP_4));
        // haven't any employees in constants.EmployeeServiceConstants.EMP_LIST with department 4
    }

    @Test
    void shouldReturnCorrectCollectionWhenPrintAllFromDepartmentCalled() {
        assertThat(out.printAllFromDepartment(DEP_1)).containsExactlyInAnyOrderElementsOf(EMP_LIST_2);
    }

    @Test
    void shouldReturnCorrectMapWhenPrintAllSortedByDepartmentCalled() {
        assertThat(out.printAllSortedByDepartment()).containsExactlyInAnyOrderEntriesOf(EMP_MAP);
    }

    @Test
    void shouldReturnCorrectResultWithPrintSalaryPerDepartmentCalled() {
        assertEquals(SUM_SALARY_DEP_1, out.printSalaryPerDepartment(DEP_1));
    }
}