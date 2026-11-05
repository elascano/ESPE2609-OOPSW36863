/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Product;
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
public class ProductTest {
    
    public ProductTest() {
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
     * Test of getName method, of class Product.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Product.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Product instance = new Product();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSellingPrice method, of class Product.
     */
    @Test
    public void testGetSellingPrice() {
        System.out.println("getSellingPrice");
        Product instance = new Product();
        float expResult = 0.0F;
        float result = instance.getSellingPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSellingPrice method, of class Product.
     */
    @Test
    public void testSetSellingPrice() {
        System.out.println("setSellingPrice");
        float sellingPrice = 0.0F;
        Product instance = new Product();
        instance.setSellingPrice(sellingPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Product.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Product.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Product instance = new Product();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCost method, of class Product.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Product instance = new Product();
        float expResult = 0.0F;
        float result = instance.getCost();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCost method, of class Product.
     */
    @Test
    public void testSetCost() {
        System.out.println("setCost");
        float cost = 0.0F;
        Product instance = new Product();
        instance.setCost(cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
     @Test
    public void testCalculateFinalPrice() {
        System.out.println("calculateFinalPrice");
        Product instance = new Product(1, "Salsa Extra", 0.40f, 0.10f);
        float expResult = 0.40f;
        float result = instance.calculateFinalPrice();
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    public void testCalculateProfit() {
        System.out.println("calculateProfit");
        Product instance = new Product(2, "Topping Chips", 2.50f, 1.00f);
        float expResult = 1.50f;
        float result = instance.calculateProfit();
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    public void testCalculateProfitMargin() {
        System.out.println("calculateProfitMargin");
        Product instance = new Product(3, "Cono Extra", 2.00f, 1.00f);
        float expResult = 50.0f;
        float result = instance.calculateProfitMargin();
        assertEquals(expResult, result, 0.001f);
    }
    
}
