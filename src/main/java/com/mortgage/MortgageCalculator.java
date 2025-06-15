package com.mortgage;

public class MortgageCalculator {
	public static double calculateMonthlyPayment(double principal, double annualRate, int termYears) {
	    if (annualRate == 0) {
	        return principal / (termYears * 12);  // Simple equal monthly payments
	    }
	    double monthlyRate = annualRate / 12 / 100;
	    int totalMonths = termYears * 12;
	    return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -totalMonths));
    }
}
