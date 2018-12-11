package com.spring.challenge.business;

import com.spring.challenge.infra.Track;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Track
public class InssCalculatorImpl implements InssCalculator {

    private static final BigDecimal HUNDRED = new BigDecimal("100");

    // First Range
    BigDecimal firstRangeSalary = new BigDecimal("1693.72");
    BigDecimal firstRangePercent = new BigDecimal("8.00");

    // Second Range
    BigDecimal secondRangeSalary = new BigDecimal("2822.90");
    BigDecimal secondRangePercent = new BigDecimal("9.00");

    // Max Salary Range
    BigDecimal maxSalaryForContrib = new BigDecimal("5645.80");
    BigDecimal maxSalaryPercent = new BigDecimal("11.00");

    @Override
    public BigDecimal calculateContribution(BigDecimal salary) {
        BigDecimal contribution;
        if (salary.compareTo(firstRangeSalary) <= 0) {
            contribution = salary.multiply(firstRangePercent.divide(HUNDRED));
        } else if (salary.compareTo(secondRangeSalary) <= 0) {
            contribution = salary.multiply(secondRangePercent.divide(HUNDRED));
        } else if (salary.compareTo(maxSalaryForContrib) <= 0) {
            contribution = salary.multiply(maxSalaryPercent.divide(HUNDRED));
        } else {
            contribution = maxSalaryForContrib.multiply(maxSalaryPercent.divide(HUNDRED));
        }
        return contribution.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }
}