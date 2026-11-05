/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Beverage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Isabel Espinosa, EsFuGa
 */
public class BeverageTest {
    
    public BeverageTest() {
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
     * Test of getSize method, of class Beverage.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Beverage instance = null;
        char expResult = ' ';
        char result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSize method, of class Beverage.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        char size = ' ';
        Beverage instance = null;
        instance.setSize(size);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTemperature method, of class Beverage.
     */
    @Test
    public void testIsTemperature() {
        System.out.println("isTemperature");
        Beverage instance = null;
        boolean expResult = false;
        boolean result = instance.isTemperature();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTemperature method, of class Beverage.
     */
    @Test
    public void testSetTemperature() {
        System.out.println("setTemperature");
        boolean temperature = false;
        Beverage instance = null;
        instance.setTemperature(temperature);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculatePriceBySize method, of class Beverage.
     */
    @Test
    public void testCalculatePriceBySize() {
        System.out.println("calculatePriceBySize");
        Beverage instance = null;
        double expResult = 0.0;
        double result = instance.calculatePriceBySize();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculatePriceBySizeMedium() {
        System.out.println("calculatePriceBySize - Medium");
        // Tamaño 'M' añade +$0.50 al precio base (1.80 + 0.50 = 2.30)
        Beverage instance = new Beverage('M', true, 7, "Café Cappuccino", 1.80f, 0.60f);
        float expResult = 2.30f;
        float result = (float) instance.calculatePriceBySize();
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    public void testCalculatePriceBySizeSmall() {
        System.out.println("calculatePriceBySize - Small");
        // Tamaño 'S' mantiene el precio base (1.50)
        Beverage instance = new Beverage('S', true, 11, "Té Caliente", 1.50f, 0.40f);
        float expResult = 1.50f;
        float result = (float) instance.calculatePriceBySize();
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    public void testCalculatePreparationCost() {
        System.out.println("calculatePreparationCost");
        Beverage instance = new Beverage('L', false, 9, "Mochaccino Helado", 3.20f, 1.20f);
        float expResult = 1.20f;
        float result = instance.calculatePreparationCost();
        assertEquals(expResult, result, 0.001f);
    }
}
