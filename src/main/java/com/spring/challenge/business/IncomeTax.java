package com.spring.challenge.business;

import java.math.BigDecimal;

public interface IncomeTax {
    BigDecimal calculateTax(BigDecimal salary);
}
