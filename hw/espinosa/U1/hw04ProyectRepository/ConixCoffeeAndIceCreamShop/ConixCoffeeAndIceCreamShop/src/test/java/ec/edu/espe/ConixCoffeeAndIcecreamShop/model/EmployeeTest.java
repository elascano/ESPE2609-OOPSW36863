/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Employee;
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
public class EmployeeTest {
    
    public EmployeeTest() {
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
     * Test of login method, of class Employee.
     */
    @Test
    public void testCreateEmployeeWithNullUsername() {
    System.out.println("create employee with null username");
    Employee employee = new Employee(null, "password123", false);
    assertEquals(null, employee.getUsername());
    }

    @Test
    public void testLoginWithIncorrectUsername() {
        System.out.println("login with incorrect username");
        Employee employee = new Employee("cashier", "password123", false);
        boolean result = employee.login("manager", "password123");
        assertFalse(result);
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        System.out.println("login with incorrect password");
        Employee employee = new Employee("cashier", "password123", false);

        boolean result = employee.login("cashier", "wrongPassword");

        assertFalse(result);
    }

    @Test
    public void testCreateEmployeeWithEmptyPassword() {
    System.out.println("create employee with empty password");
    Employee employee = new Employee("cashier", "", false);
    assertEquals("", employee.getPassword());
}

    @Test
    public void testLoginWithNullPassword() {
        System.out.println("login with null password");
        Employee employee = new Employee("cashier", "password123", false);
        boolean result = employee.login("cashier", null);
        assertFalse(result);
    }

    @Test
    public void testClockIn() {
        System.out.println("clock in");
        Employee employee = new Employee("cashier", "password123", false);
        employee.clockIn();
        assertTrue(employee.isClockedIn());
    }

    @Test
    public void testClockOut() {
        System.out.println("clock out");
        Employee employee = new Employee("cashier", "password123", true);
        employee.clockOut();
        assertFalse(employee.isClockedIn());
    }

    @Test
    public void testGetUsername() {
        System.out.println("get username");
        Employee employee = new Employee("cashier", "password123", false);
        String result = employee.getUsername();
        assertEquals("cashier", result);
    }

    @Test
    public void testSetUsernameWithSpaces() {
        System.out.println("set username with spaces");
        Employee employee = new Employee("cashier", "password123", false);
        employee.setUsername("  barista  ");
        assertEquals("barista", employee.getUsername());
    }

    @Test
    public void testSetEmployeeUsernameWithBlankValue() {
    System.out.println("set employee username with blank value");
    Employee employee = new Employee("cashier", "password123", false);
    employee.setUsername("   ");
    assertEquals("", employee.getUsername());
    }
}
