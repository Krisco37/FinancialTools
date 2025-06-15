package com.mortgage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MortgageCalculatorTest {

    @Test
    void testCalculateMonthlyPayment() {
        // Given
        double principal = 200000;  // Loan amount
        double annualRate = 5;      // Annual interest rate in percentage
        int termYears = 30;         // Loan term in years

        // When
        double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(principal, annualRate, termYears);

        // Then
        // Expected value calculated manually or using a financial calculator
        double expectedPayment = 1073.64;
        assertEquals(expectedPayment, monthlyPayment, 0.01, "Monthly payment calculation is incorrect");
    }

    @Test
    void testZeroPrincipal() {
        assertEquals(0, MortgageCalculator.calculateMonthlyPayment(0, 5, 30), "Zero principal should result in zero payment");
    }

    @Test
    void testZeroInterestRate() {
        double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(100000, 0, 30);
        assertEquals(277.78, monthlyPayment, 0.01, "Zero interest rate should result in a simple principal division");
    }

    @Test
    void testShortTermLoan() {
        double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(50000, 5, 5);
        double expectedPayment = 943.56;
        assertEquals(expectedPayment, monthlyPayment, 0.01, "Short-term loan calculation mismatch");
    }
}
