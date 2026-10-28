/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Owner;
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
public class OwnerTest {
    
    public OwnerTest() {
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
     * Test of login method, of class Owner.
     */
    @Test
    public void testLoginWithCorrectCredentials() {
        System.out.println("login with correct credentials");
        Owner owner = new Owner("manager", "secret123");
        boolean result = owner.login("manager", "secret123");
        assertTrue(result);
    }

    @Test
    public void testCreateOwnerWithNullPassword() {
    System.out.println("create owner with null password");
    Owner owner = new Owner("manager", null);
    assertEquals(null, owner.getPassword());
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        System.out.println("login with incorrect password");
        Owner owner = new Owner("manager", "secret123");
        boolean result = owner.login("manager", "wrongPassword");
        assertFalse(result);
    }

    @Test
    public void testLoginWithNullUsername() {
        System.out.println("login with null username");
        Owner owner = new Owner("manager", "secret123");
        boolean result = owner.login(null, "secret123");
        assertFalse(result);
    }

    @Test
    public void testCreateOwnerWithBlankUsername() {
    System.out.println("create owner with blank username");
    Owner owner = new Owner("   ", "password123");
    assertEquals("", owner.getUsername());
    }

    @Test
    public void testGetUsername() {
        System.out.println("get username");
        Owner owner = new Owner("manager", "secret123");
        String result = owner.getUsername();
        assertEquals("manager", result);
    }

    @Test
    public void testSetUsername() {
        System.out.println("set username");
        Owner owner = new Owner("manager", "secret123");
        owner.setUsername("owner");
        assertEquals("owner", owner.getUsername());
    }

    @Test
    public void testSetUsernameWithSpaces() {
    System.out.println("set username with spaces");
    Owner owner = new Owner("manager", "secret123");
    owner.setUsername("  coffeeOwner  ");
    assertEquals("coffeeOwner", owner.getUsername());
}

    @Test
    public void testSetOwnerUsernameWithNullValue() {
    System.out.println("set owner username with null value");
    Owner owner = new Owner("manager", "password123");
    owner.setUsername(null);
    assertEquals(null, owner.getUsername());
    }
    
    @Test
    public void testSetPassword() {
    System.out.println("set password");
    Owner owner = new Owner("manager", "secret123");
    owner.setPassword("newPassword123");
    assertEquals("newPassword123", owner.getPassword());
    }
    
}
