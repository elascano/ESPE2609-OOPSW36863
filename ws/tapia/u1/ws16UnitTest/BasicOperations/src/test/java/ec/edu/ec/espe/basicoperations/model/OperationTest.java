package ec.edu.ec.espe.basicoperations.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void add() {
        System.out.println("Sum");
        float n1 = 1.4f;
        float n2 = 3.4f;
        Operation instance = new Operation();
        float expResult = 4.8f;
        float result = instance.add(n1, n2);
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    void subtract() {
        System.out.println("Subtract");
        float n1 = 10.0f;
        float n2 = 4.5f;
        Operation instance = new Operation();
        float expResult = 5.5f;
        float result = instance.subtract(n1, n2);
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    void multiply() {
        System.out.println("Multiply");
        float n1 = 3.0f;
        float n2 = 2.5f;
        Operation instance = new Operation();
        float expResult = 7.5f;
        float result = instance.multiply(n1, n2);
        assertEquals(expResult, result, 0.001f);
    }

    @Test
    void divide() {
        System.out.println("Divide");
        float n1 = 10.0f;
        float n2 = 4.0f;
        Operation instance = new Operation();
        float expResult = 2.5f;
        float result = instance.divide(n1, n2);
        assertEquals(expResult, result, 0.001f);
    }
}
