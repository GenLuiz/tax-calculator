package com.spring.challenge.controller;

import com.spring.challenge.business.InssCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
public class InssController {

    @Autowired
    InssCalculator inssCalculator;

    @RequestMapping(value = "/inss", produces = MediaType.APPLICATION_JSON_VALUE)
    public String inss(@RequestParam("salary") BigDecimal salary) {
        return String.valueOf(inssCalculator.calculateContribution(salary));
    }
}