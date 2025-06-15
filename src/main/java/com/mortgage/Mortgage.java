/**
 * Represents a simple Mortgage object which contains balance, rate,
 * payment, escrow and maturity date.
 * 
 * Author: Aaron Lindsay
 * Date: June 14, 2025
 *//**
 * Represents a simple Mortgage object.
 * 
 * Author: Aaron Lindsay
 * Date: June 14, 2025
 */
package com.mortgage;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Mortgage {

	//Variables
	protected double balance;
	protected double rate;
	protected double payment;
	protected double escrow;	
	protected LocalDate maturityDate;
	DateTimeFormatter maturityDateFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
	
    /**
     * Constructs a Mortgage object with a given balance, rate, payment, escrow, and maturityDate.
     *
     * @param balance remaining balance
     * @param rate the initial balance (must be >= 0)
     * @param payment the initial balance (must be >= 0)
     * @param escrow the initial balance (must be >= 0)
     */
	public Mortgage(double _balance, double _rate, double _payment, double _escrow, String _maturityDate) {
		YearMonth ym = YearMonth.parse(_maturityDate, maturityDateFormatter);
		
		balance = _balance;
		rate = _rate;
		payment = _payment;
		escrow = _escrow;
		maturityDate = ym.atDay(1);
	}
	
	//Section Start:Getters

	// Get balance
	public double getBalance() {
	    return balance;
	}

	// Get rate
	public double getRate() {
	    return rate;
	}

	// Get payment
	public double getPayment() {
	    return payment;
	}

	// Get escrow
	public double getEscrow() {
	    return escrow;
	}

	// Get maturityDate
	public LocalDate getMaturityDate() {
	    return maturityDate;
	}

	// Get totalPayment (payment + escrow)
	public double getTotalPayment() {
	    return getPayment() + getEscrow();
	}
	//Section End 
	
	//Section Start:Setters

	// Set balance
	public void setBalance(double newBalance) {
	    this.balance = newBalance;
	}

	// Set rate
	public void setRate(double newRate) {
	    this.rate = newRate;
	}

	// Set payment
	public void setPayment(double newPayment) {
	    this.payment = newPayment;
	}

	// Set escrow
	public void setEscrow(double newEscrow) {
	    this.escrow = newEscrow;
	}

	// Set maturityDate from "MM/yyyy" formatted string
	public void setMaturityDate(String newMaturityDate) {
	    YearMonth ym = YearMonth.parse(newMaturityDate, maturityDateFormatter);
	    this.maturityDate = ym.atDay(1);
	}
	//Section End
	
	//Calculates and returns total number of payments left
	public long NumberOfPayments() {
		LocalDate today = LocalDate.now().withDayOfMonth(1);
		long monthsBetween = ChronoUnit.MONTHS.between(today, getMaturityDate());
		return monthsBetween;
	}
	
	public String mortgageInfoToString() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percentage = NumberFormat.getPercentInstance(Locale.US);
		percentage.setMinimumFractionDigits(3);
		
		return 
				"Mortgage Info: \n" +
				"  Balance: " + currency.format(getBalance()) + "\n" + 
				"  Rate: " + percentage.format(getRate()) + "\n" +
				"  Base Payment: " + currency.format(getPayment()) + "\n" + 
				"  Escrow: " + currency.format(getEscrow()) + "\n" +
				"  Total Payment: " + currency.format(getTotalPayment()) + "\n" +
				"  Maturity Date: " + maturityDate.format(maturityDateFormatter) + "\n" +
				"  Payments Left: " + NumberOfPayments();
	}	
}

