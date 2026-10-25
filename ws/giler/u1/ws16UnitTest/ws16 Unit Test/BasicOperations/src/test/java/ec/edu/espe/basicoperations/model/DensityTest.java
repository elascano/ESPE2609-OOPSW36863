package ec.edu.espe.basicoperations.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class DensityTest {
    
    public DensityTest() {
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
     * Test of computeDensity method, of class Density.
     */
    @Test
    public void testComputeDensity() {
        System.out.println("computeDensity");
        float mass = 0.0F;
        float volume = 0.0F;
        Density instance = new Density();
        float expResult = 0.0F;
        float result = instance.computeDensity(mass, volume);
        assertEquals(expResult, result, 0);

    }
    
}
