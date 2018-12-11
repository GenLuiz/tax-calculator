package com.spring.challenge.controller;

import com.spring.challenge.business.IncomeTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class IncomeTaxController {

    @Autowired
    IncomeTax incomeTax;

    @RequestMapping(value = "/incometax", produces = MediaType.APPLICATION_JSON_VALUE)
    public String incomeTax(@RequestParam("salary") BigDecimal salary) {
        return String.valueOf(incomeTax.calculateTax(salary));
    }
}
