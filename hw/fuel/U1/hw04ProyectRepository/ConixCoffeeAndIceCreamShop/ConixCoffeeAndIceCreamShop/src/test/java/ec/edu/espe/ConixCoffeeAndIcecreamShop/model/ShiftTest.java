/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.ConixCoffeeAndIcecreamShop.model;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Shift;
import java.time.LocalTime;
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
public class ShiftTest {
    
    public ShiftTest() {
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
     * Test of calculateShiftHours method, of class Shift.
     */
    @Test
    public void testCalculateEightHourShift() {
        System.out.println("calculate eight hour shift");
        Shift shift = new Shift(LocalTime.of(8, 0), LocalTime.of(16, 0));
        double result = shift.calculateShiftHours();
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testCalculateFractionalShift() {
        System.out.println("calculate fractional shift");
        Shift shift = new Shift(LocalTime.of(8, 30), LocalTime.of(16, 0));
        double result = shift.calculateShiftHours();
        assertEquals(7.5, result, 0.001);
    }

    @Test
    public void testCalculateNightShift() {
        System.out.println("calculate night shift");
        Shift shift = new Shift(LocalTime.of(22, 0), LocalTime.of(6, 0));
        double result = shift.calculateShiftHours();
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testCalculateSameStartAndEndTime() {
        System.out.println("calculate same start and end time");
        Shift shift = new Shift(LocalTime.of(9, 0), LocalTime.of(9, 0));
        double result = shift.calculateShiftHours();
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testSetNullEndTime() {
    System.out.println("set null end time");
    Shift shift = new Shift(LocalTime.of(8, 0), LocalTime.of(16, 0));
    shift.setEndTime(null);
    assertEquals(null, shift.getEndTime());
}

    @Test
    public void testGetEndTime() {
        System.out.println("get end time");
        LocalTime expectedTime = LocalTime.of(17, 0);
        Shift shift = new Shift(LocalTime.of(9, 0), expectedTime);
        LocalTime result = shift.getEndTime();
        assertEquals(expectedTime, result);
    }

    @Test
    public void testSetStartTime() {
        System.out.println("set start time");
        Shift shift = new Shift(LocalTime.of(8, 0), LocalTime.of(16, 0));
        shift.setStartTime(LocalTime.of(10, 0));
        assertEquals(LocalTime.of(10, 0), shift.getStartTime());
    }

    @Test
    public void testCreateShiftWithNullStartTime() {
    System.out.println("create shift with null start time");
    Shift shift = new Shift(null, LocalTime.of(16, 0));
    assertEquals(null, shift.getStartTime());
    }

    @Test
    public void testCalculateHoursAfterChangingStartTime() {
        System.out.println("calculate hours after changing start time");
        Shift shift = new Shift(LocalTime.of(8, 0), LocalTime.of(16, 0));
        shift.setStartTime(LocalTime.of(10, 0));
        assertEquals(6.0, shift.calculateShiftHours(), 0.001);
    }

    @Test
    public void testCalculateHoursAfterChangingEndTime() {
        System.out.println("calculate hours after changing end time");
        Shift shift = new Shift(LocalTime.of(8, 0), LocalTime.of(16, 0));
        shift.setEndTime(LocalTime.of(17, 30));
        assertEquals(9.5, shift.calculateShiftHours(), 0.001);
    }
    
}
