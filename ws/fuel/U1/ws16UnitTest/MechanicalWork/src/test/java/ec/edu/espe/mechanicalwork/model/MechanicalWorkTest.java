package ec.edu.espe.mechanicalwork.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Aleandro Fuel
 */
public class MechanicalWorkTest {

    private final MechanicalWork work = new MechanicalWork();


    @Test
    public void testCalculateWork1() {
        float result = work.calculateWork(10.0F, 5.0F);
        assertEquals(50.0F, result, 0.001F);
    }

    @Test
    public void testCalculateWork2() {

        float result = work.calculateWork(2.5F, 4.0F);
        assertEquals(10.0F, result, 0.001F);
    }

    @Test
    public void testCalculateWork3() {

        float result = work.calculateWork(100.0F, 0.5F);
        assertEquals(50.0F, result, 0.001F);
    }

    @Test
    public void testCalculateWork4() {

        float result = work.calculateWork(7.5F, 2.0F);
        assertEquals(15.0F, result, 0.001F);
    }

    @Test
    public void testCalculateWork5() {

        float result = work.calculateWork(10.0F, -5.0F);
        assertEquals(50.0F, result, 0.001F); 
    }

    
    @Test
    public void testCalculateWork6() {

        float result = work.calculateWork(0.0F, -10.0F);
        assertEquals(0.0F, result, 0.001F);
    }

    @Test
    public void testCalculateWork7() {

        float result = work.calculateWork(0.0F, 0.0F);
        assertEquals(0.0F, result, 0.001F);
    }

    @Test
    public void testCalculateWork8() {
        float result = work.calculateWork(999999.0F, 0.000001F);
        assertEquals(0.999999F, result, 0.0001F);
    }
    @Test
    public void testCalculateWork9() {

        float result = work.calculateWork(-5.0F, -2.0F);
        assertEquals(-10.0F, result, 0.001F); 
    }
    @Test
    public void testCalculateWork10() {
        // CP10: Límite máximo soportado por el tipo de dato float
        float result = work.calculateWork(Float.MAX_VALUE, 1.0F);
        assertEquals(Float.MAX_VALUE, result, 0.001F);
    }
}