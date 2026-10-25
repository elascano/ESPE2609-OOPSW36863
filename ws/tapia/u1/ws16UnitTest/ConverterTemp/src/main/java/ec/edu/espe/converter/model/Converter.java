package ec.edu.espe.converter.model;

public class Converter {


    public float celsiusToFahrenheit(float celsius) {
        return (celsius * 9.0f / 5.0f) + 32.0f;
    }

    // Fórmula: (F - 32) * 5/9
    public float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32.0f) * 5.0f / 9.0f;
    }
}
