package ec.edu.espe.converter.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {



    @Test
    void testCelsiusToFahrenheit_StandardRoom() {
        System.out.println("Caso Bueno 1");
        float celsius = 20.0f;
        Converter instance = new Converter();
        float expResult = 68.0f;
        float result = instance.celsiusToFahrenheit(celsius);
        assertEquals(expResult, result, 0);
    }

    @Test
    void testCelsiusToFahrenheit_FreezingPoint() {
        System.out.println("Caso Bueno 2");
        float celsius = 0.0f;
        Converter instance = new Converter();
        float expResult = 32.0f;
        float result = instance.celsiusToFahrenheit(celsius);
        assertEquals(expResult, result, 0);
    }

    @Test
    void testFahrenheitToCelsius_BodyTemperature() {
        System.out.println("Caso Bueno 3");
        float fahrenheit = 98.6f;
        Converter instance = new Converter();
        float expResult = 37.0f;
        float result = instance.fahrenheitToCelsius(fahrenheit);
        assertEquals(expResult, result, 0);
    }

    @Test
    void testFahrenheitToCelsius_BoilingPoint() {
        System.out.println("Caso Bueno 4");
        float fahrenheit = 212.0f;
        Converter instance = new Converter();
        float expResult = 100.0f;
        float result = instance.fahrenheitToCelsius(fahrenheit);
        assertEquals(expResult, result, 0);
    }

    @Test
    void testCelsiusToFahrenheit_NegativeSubZero() {
        System.out.println("Caso Malo 1");
        float celsius = -40.0f;
        Converter instance = new Converter();
        float expResult = -40.0f;
        float result = instance.celsiusToFahrenheit(celsius);
        assertEquals(expResult, result, 0);
    }

    @Test
    void testFahrenheitToCelsius_BelowZeroFahrenheit() {
        System.out.println("Caso Malo 2");
        float fahrenheit = -10.0f;
        Converter instance = new Converter();
        float expResult = -23.3333f;
        float result = instance.fahrenheitToCelsius(fahrenheit);
        assertEquals(expResult, result, 0);
    }

    @Test
    void testCelsiusToFahrenheit_ImprobableNegative() {
        System.out.println("Caso Malo 3");
        float celsius = -300.0f;
        Converter instance = new Converter();
        float expResult = -508.0f;
        float result = instance.celsiusToFahrenheit(celsius);
        assertEquals(expResult, result, 0);
    }

    @Test
    void testCelsiusToFahrenheit_AbsoluteZero() {
        System.out.println("Caso Fuerte 1");
        float celsius = -273.15f;
        Converter instance = new Converter();
        float expResult = -459.67f;
        float result = instance.celsiusToFahrenheit(celsius);
        assertEquals(expResult, result, 0);
    }

    @Test
    void testCelsiusToFahrenheit_ExtremeSun() {
        System.out.println("Caso Fuerte 2");
        float celsius = 5500.0f;
        Converter instance = new Converter();
        float expResult = 9932.0f;
        float result = instance.celsiusToFahrenheit(celsius);
        assertEquals(expResult, result, 0);
    }

    @Test
    void testFahrenheitToCelsius_LargeFloatLimit() {
        System.out.println("Caso Fuerte 3");
        float fahrenheit = 100000.0f;
        Converter instance = new Converter();
        float expResult = 55537.777f;
        float result = instance.fahrenheitToCelsius(fahrenheit);
        assertEquals(expResult, result, 0);
    }
}
