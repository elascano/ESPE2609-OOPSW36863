package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Tax;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaxTest {

    // =========================
    // CONSTRUCTOR TESTS
    // =========================

    @Test
    public void testTaxConstructorWithNormalRate() {
        Tax instance = new Tax(12);

        assertEquals(12.0, instance.getTaxRate());
    }

    @Test
    public void testTaxConstructorWithZeroRate() {
        Tax instance = new Tax(0);

        assertEquals(0.0, instance.getTaxRate());
    }

    @Test
    public void testTaxConstructorWithMaximumRate() {
        Tax instance = new Tax(100);

        assertEquals(100.0, instance.getTaxRate());
    }

    @Test
    public void testTaxConstructorWithNegativeRate() {
        Tax instance = new Tax(-1);
    }

    @Test
    public void testTaxConstructorWithRateAboveMaximum() {
        Tax instance = new Tax(101);
    }

    @Test
    public void testTaxConstructorWithNaNRate() {
        Tax instance = new Tax(Double.NaN);
    }

    @Test
    public void testTaxConstructorWithInfiniteRate() {
        Tax instance = new Tax(Double.POSITIVE_INFINITY);
    }


    // =========================
    // CALCULATE TAX TESTS
    // =========================

    @Test
    public void testCalculateTax() {
        Tax instance = new Tax(12);

        double result = instance.calculateTax(100);

        assertEquals(12.0, result);
    }

    @Test
    public void testCalculateTaxWith15Percent() {
        Tax instance = new Tax(15);

        double result = instance.calculateTax(200);

        assertEquals(30.0, result);
    }

    @Test
    public void testCalculateTaxWithZeroRate() {
        Tax instance = new Tax(0);

        double result = instance.calculateTax(100);

        assertEquals(0.0, result);
    }

    @Test
    public void testCalculateTaxWithZeroAmount() {
        Tax instance = new Tax(12);

        double result = instance.calculateTax(0);

        assertEquals(0.0, result);
    }

    @Test
    public void testCalculateTaxWithDecimalAmount() {
        Tax instance = new Tax(15);

        double result = instance.calculateTax(10.50);

        assertEquals(1.575, result);
    }

    @Test
    public void testCalculateTaxWithMaximumRate() {
        Tax instance = new Tax(100);

        double result = instance.calculateTax(50);

        assertEquals(50.0, result);
    }

    @Test
    public void testCalculateTaxWithNegativeAmount() {
        Tax instance = new Tax(12);

        instance.calculateTax(-50);
    }

    @Test
    public void testCalculateTaxWithNaNAmount() {
        Tax instance = new Tax(12);

        instance.calculateTax(Double.NaN);
    }

    @Test
    public void testCalculateTaxWithInfiniteAmount() {
        Tax instance = new Tax(12);

        instance.calculateTax(Double.POSITIVE_INFINITY);
    }


    // =========================
    // SET TAX RATE TESTS
    // =========================

    @Test
    public void testSetTaxRate() {
        Tax instance = new Tax(12);

        instance.setTaxRate(15);

        assertEquals(15.0, instance.getTaxRate());
    }

    @Test
    public void testSetTaxRateToZero() {
        Tax instance = new Tax(12);

        instance.setTaxRate(0);

        assertEquals(0.0, instance.getTaxRate());
    }

    @Test
    public void testSetTaxRateToMaximum() {
        Tax instance = new Tax(12);

        instance.setTaxRate(100);

        assertEquals(100.0, instance.getTaxRate());
    }

    @Test
    public void testSetTaxRateWithNegativeValue() {
        Tax instance = new Tax(12);

        instance.setTaxRate(-1);
    }

    @Test
    public void testSetTaxRateAboveMaximum() {
        Tax instance = new Tax(12);

        instance.setTaxRate(101);
    }

    @Test
    public void testSetTaxRateWithNaN() {
        Tax instance = new Tax(12);

        instance.setTaxRate(Double.NaN);
    }

    @Test
    public void testSetTaxRateWithInfiniteValue() {
        Tax instance = new Tax(12);

        instance.setTaxRate(Double.POSITIVE_INFINITY);
    }
}