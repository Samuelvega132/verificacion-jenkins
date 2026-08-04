package com.ejemplo;

import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testSumar() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.sumar(2, 3)); // Fallará intencionalmente "La suma debe ser igual a 5");
    }

    @Test
    void testEsPar() {
        Calculator calc = new Calculator();
        assertTrue(calc.esPar(4), "4 debe ser un número par");
        assertFalse(calc.esPar(7), "7 debe ser un número impar");
    }
}