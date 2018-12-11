package com.spring.challenge.business;

import com.spring.challenge.infra.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Track
public class IncomeTaxImp implements IncomeTax {

    @Autowired
    InssCalculator inssCalculator;

    private static final BigDecimal HUNDRED = new BigDecimal("100");

    // First Range
    BigDecimal firstRangeSalary = new BigDecimal("1903.98");
    BigDecimal firstRangePercent = new BigDecimal("0.00");

    // Second Range
    BigDecimal secondRangeSalary = new BigDecimal("2826.65");
    BigDecimal secondRangePercent = new BigDecimal("7.50");
    BigDecimal secondRangeDeduction = new BigDecimal("142.80");

    // thirth Salary Range
    BigDecimal thirthRangeSalary = new BigDecimal("3751.05");
    BigDecimal thirthSalaryPercent = new BigDecimal("15.00");
    BigDecimal thirthRangeDeduction = new BigDecimal("354.80");

    // fourth Salary Range
    BigDecimal fourthRangeSalary = new BigDecimal("4664.68");
    BigDecimal fourthSalaryPercent = new BigDecimal("22.50");
    BigDecimal fourthRangeDeduction = new BigDecimal("636.13");

    // max Salary Range
    BigDecimal maxSalaryPercent = new BigDecimal("27.50");
    BigDecimal maxRangeDeduction = new BigDecimal("869.36");


    @Override
    public BigDecimal calculateTax(BigDecimal salary) {
       BigDecimal incomeTax = new BigDecimal(0);
       if(salary.compareTo(firstRangeSalary)<= 0){
           return incomeTax;
       }else{
           BigDecimal baseSalary = salary.subtract(inssCalculator.calculateContribution(salary));

           if((salary.compareTo(secondRangeSalary) <= 0)){
               incomeTax = baseSalary.multiply(secondRangePercent.divide(HUNDRED)).subtract(secondRangeDeduction);
           }else if(salary.compareTo(thirthRangeSalary) <= 0){
               incomeTax = baseSalary.multiply(thirthSalaryPercent.divide(HUNDRED)).subtract(thirthRangeDeduction);
           }else if(salary.compareTo(fourthRangeSalary) <= 0){
               incomeTax = baseSalary.multiply(fourthSalaryPercent.divide(HUNDRED)).subtract(fourthRangeDeduction);
           }else if(salary.compareTo(fourthRangeSalary) == 1){
               incomeTax = baseSalary.multiply(maxSalaryPercent.divide(HUNDRED)).subtract(maxRangeDeduction);
           }
       }
       return incomeTax.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }
}
