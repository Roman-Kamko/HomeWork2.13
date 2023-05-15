package com.example.homework.services.impl;

import com.example.homework.exceptions.InvalidInputException;
import com.example.homework.services.ValidatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static constants.ValidatorServiceConstants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorServiceImplTest {

    private final ValidatorService out = new ValidatorServiceImpl();

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(BAD_INPUT_1, GOOD_INPUT),
                Arguments.of(BAD_INPUT_2, GOOD_INPUT),
                Arguments.of(BAD_INPUT_3, GOOD_INPUT),
                Arguments.of(BAD_INPUT_4, GOOD_INPUT),
                Arguments.of(BAD_INPUT_5, GOOD_INPUT),
                Arguments.of(null, GOOD_INPUT),
                Arguments.of(GOOD_INPUT, BAD_INPUT_1),
                Arguments.of(GOOD_INPUT, BAD_INPUT_2),
                Arguments.of(GOOD_INPUT, BAD_INPUT_3),
                Arguments.of(GOOD_INPUT, BAD_INPUT_4),
                Arguments.of(GOOD_INPUT, BAD_INPUT_5),
                Arguments.of(GOOD_INPUT, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void checkInput(String name, String surname) {
        assertThrows(InvalidInputException.class, () -> out.checkInput(name, surname));
    }
}