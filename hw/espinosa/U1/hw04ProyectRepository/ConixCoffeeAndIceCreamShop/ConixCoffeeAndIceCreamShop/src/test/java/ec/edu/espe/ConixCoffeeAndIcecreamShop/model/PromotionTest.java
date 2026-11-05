/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Promotion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class PromotionTest {
    
    public PromotionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValid method, of class Promotion.
     */
    @Test
    public void testIsValidWithTrueValue() {
        System.out.println("is valid with true value");
        Promotion promotion = new Promotion(true, 10.0);
        boolean result = promotion.isValid();
        assertTrue(result);
    }

    @Test
    public void testIsValidWithFalseValue() {
        System.out.println("is valid with false value");
        Promotion promotion = new Promotion(false, 10.0);
        boolean result = promotion.isValid();
        assertFalse(result);
    }

    @Test
    public void testSetValidToFalse() {
        System.out.println("set valid to false");
        Promotion promotion = new Promotion(true, 10.0);
        promotion.setValid(false);
        assertFalse(promotion.isValid());
    }

    @Test
    public void testSetValidToTrue() {
        System.out.println("set valid to true");
        Promotion promotion = new Promotion(false, 10.0);
        promotion.setValid(true);
        assertTrue(promotion.isValid());
    }

    @Test
    public void testComputeTenPercentDiscount() {
        System.out.println("compute ten percent discount");
        Promotion promotion = new Promotion(true, 10.0);
        double result = promotion.computeDiscount(100.0);
        assertEquals(10.0, result, 0.001);
    }

    @Test
    public void testComputeTwentyFivePercentDiscount() {
        System.out.println("compute twenty five percent discount");
        Promotion promotion = new Promotion(true, 25.0);
        double result = promotion.computeDiscount(80.0);
        assertEquals(20.0, result, 0.001);
    }

    @Test
    public void testComputeDiscountWithZeroPercentage() {
        System.out.println("compute discount with zero percentage");
        Promotion promotion = new Promotion(true, 0.0);
        double result = promotion.computeDiscount(200.0);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testComputeDiscountWithInvalidPromotion() {
        System.out.println("compute discount with invalid promotion");
        Promotion promotion = new Promotion(false, 20.0);
        double result = promotion.computeDiscount(100.0);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testCreatePromotionWithNegativePercentage() {
    System.out.println("create promotion with negative percentage");
    Promotion promotion = new Promotion(true, -10.0);
    assertEquals(-10.0, promotion.getDiscountPercentage(), 0.001);
    }

    @Test
    public void testComputeDiscountWithNegativeAmount() {
    System.out.println("compute discount with negative amount");
    Promotion promotion = new Promotion(true, 10.0);
    double result = promotion.computeDiscount(-100.0);
    assertEquals(-10.0, result, 0.001);
    }
    
}
