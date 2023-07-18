package test;

import lab07.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CalculadoraTeste {

    Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Multiplicação Simples")
    void testeMultiplicar() {
        assertEquals(20, calculadora.multiplicar(4, 5),
                "Multiplicação Simples Funcionou!");
    }

    @RepeatedTest(5)
    @DisplayName("Teste de multiplicação por zero")
    void testMultiplyWithZero() {
        assertEquals(0, calculadora.multiplicar(0, 5), "Multiplicação por zero deve dar zero");
        assertEquals(0, calculadora.multiplicar(5, 0), "Multiplicação por zero deve dar zero");
    }
}