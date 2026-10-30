/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.OrderDetail;
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
public class OrderDetailTest {
    
    public OrderDetailTest() {
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
     * Test of getProduct method, of class OrderDetail.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        OrderDetail instance = null;
        Product expResult = null;
        Product result = instance.getProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProduct method, of class OrderDetail.
     */
    @Test
    public void testSetProduct() {
        System.out.println("setProduct");
        Product product = null;
        OrderDetail instance = null;
        instance.setProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class OrderDetail.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        OrderDetail instance = null;
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class OrderDetail.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        OrderDetail instance = null;
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitPrice method, of class OrderDetail.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        OrderDetail instance = null;
        float expResult = 0.0F;
        float result = instance.getUnitPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitPrice method, of class OrderDetail.
     */
    @Test
    public void testSetUnitPrice() {
        System.out.println("setUnitPrice");
        float unitPrice = 0.0F;
        OrderDetail instance = null;
        instance.setUnitPrice(unitPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubTotal method, of class OrderDetail.
     */
    @Test
    public void testGetSubTotal() {
        System.out.println("getSubTotal");
        OrderDetail instance = null;
        float expResult = 0.0F;
        float result = instance.getSubTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubTotal method, of class OrderDetail.
     */
    @Test
    public void testSetSubTotal() {
        System.out.println("setSubTotal");
        float subTotal = 0.0F;
        OrderDetail instance = null;
        instance.setSubTotal(subTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiscountPercentage method, of class OrderDetail.
     */
    @Test
    public void testGetDiscountPercentage() {
        System.out.println("getDiscountPercentage");
        OrderDetail instance = null;
        double expResult = 0.0;
        double result = instance.getDiscountPercentage();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiscountPercentage method, of class OrderDetail.
     */
    @Test
    public void testSetDiscountPercentage() {
        System.out.println("setDiscountPercentage");
        double discountPercentage = 0.0;
        OrderDetail instance = null;
        instance.setDiscountPercentage(discountPercentage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculateSubtotal() {
        System.out.println("calculateSubtotal");
        Product product = new Product(1, "Helado de Mora", 2.50f, 1.05f);
        OrderDetail instance = new OrderDetail(product, 3, 0.0f);
        float expResult = 7.50f;
        float result = (float) instance.calculateSubtotal();
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    public void testCalculateDiscount() {
        System.out.println("calculateDiscount");
        Product product = new Product(2, "Mochaccino", 3.00f, 1.00f);
        OrderDetail instance = new OrderDetail(product, 2, 10.0f);
        float expResult = 0.60f;
        float result = (float) instance.calculateDiscount();
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    public void testCalculateTotal() {
        System.out.println("calculateTotal");
        Product product = new Product(3, "Café Cappuccino", 2.50f, 0.90f);
        OrderDetail instance = new OrderDetail(product, 2, 20.0f);
        float expResult = 4.00f;
        float result = (float) instance.calculateTotal();
        assertEquals(expResult, result, 0.001f);
    }
}
