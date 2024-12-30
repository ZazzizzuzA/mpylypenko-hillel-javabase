package com.gmail.mpylypenko.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    @DisplayName("10 / 1 = 10.0")
    void checkDivide() {
        assertEquals(10.0, calculator.calculate(10, 1, Operation.DIVIDE), "10 / 1 should equal 10.0");
    }

    @Test
    @DisplayName("-15.59 - -4.41 = -20.0")
    void checkMinus() {
        assertEquals(-20.0, calculator.calculate(-15.59, -4.41, Operation.MINUS), "-15.59 -4.41 should equal -20.0");
    }

    @Test
    @DisplayName("9 + 7 = 16.0")
    void checkPlus() {
        assertEquals(16.0, calculator.calculate(9, 7, Operation.PLUS), "9 + 7 should equal 16.0");
    }

    @Test
    @DisplayName("3.33 * 3 = 9.99")
    void checkMultiply() {
        assertEquals(9.99, calculator.calculate(3.33, 3, Operation.MULTIPLY), "3.33 * 3 should equal 9.99");
    }
}
