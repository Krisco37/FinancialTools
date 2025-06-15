package com.mortgage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mortgage.Mortgage;

import java.time.LocalDate;

class MortgageTest {

    private Mortgage mortgage;

    @BeforeEach
    void setUp() {
        mortgage = new Mortgage(200000.0, 0.04, 1200.0, 400.0, "12/2045");
    }

    @Test
    void testConstructorInitialization() {
        assertEquals(200000.0, mortgage.getBalance());
        assertEquals(0.04, mortgage.getRate());
        assertEquals(1200.0, mortgage.getPayment());
        assertEquals(400.0, mortgage.getEscrow());
        assertEquals(LocalDate.of(2045, 12, 1), mortgage.getMaturityDate());
    }

    @Test
    void testGetTotalPayment() {
        assertEquals(1600.0, mortgage.getTotalPayment());
    }

    @Test
    void testSetBalance() {
        mortgage.setBalance(190000.0);
        assertEquals(190000.0, mortgage.getBalance());
    }

    @Test
    void testSetRate() {
        mortgage.setRate(0.035);
        assertEquals(0.035, mortgage.getRate());
    }

    @Test
    void testSetPayment() {
        mortgage.setPayment(1250.0);
        assertEquals(1250.0, mortgage.getPayment());
    }

    @Test
    void testSetEscrow() {
        mortgage.setEscrow(450.0);
        assertEquals(450.0, mortgage.getEscrow());
    }

    @Test
    void testSetMaturityDate() {
        mortgage.setMaturityDate("06/2050");
        assertEquals(LocalDate.of(2050, 6, 1), mortgage.getMaturityDate());
    }

    @Test
    void testNumberOfPayments() {
        long expectedPaymentsLeft = LocalDate.of(2045, 12, 1).getYear() * 12 + 12 - LocalDate.now().getYear() * 12 - LocalDate.now().getMonthValue();
        assertEquals(expectedPaymentsLeft, mortgage.NumberOfPayments());
    }
    
    @Test
    void testMortgageInfoToString() {
    	String expectedMortgageInfo = "Mortgage Info: \n"
    			+ "  Balance: $200,000.00\n"
    			+ "  Rate: 4.000%\n"
    			+ "  Base Payment: $1,200.00\n"
    			+ "  Escrow: $400.00\n"
    			+ "  Total Payment: $1,600.00\n"
    			+ "  Maturity Date: 12/2045\n"
    			+ "  Payments Left: 246";
    	assertEquals(expectedMortgageInfo, mortgage.mortgageInfoToString());
    //	System.out.print(mortgage.mortgageInfoToString());
    }
}
