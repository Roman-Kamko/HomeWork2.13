package com.example.homework.services.impl;

import com.example.homework.exceptions.InvalidInputException;
import com.example.homework.services.ValidatorService;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isAlpha;
@Service
public class ValidatorServiceImpl implements ValidatorService {

    @Override
    public void checkInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }
}
