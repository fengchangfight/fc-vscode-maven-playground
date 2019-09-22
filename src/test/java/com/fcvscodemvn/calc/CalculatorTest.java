package com.fcvscodemvn.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculatorTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testApp() {
        assertEquals(3, Calculator.add(1, 2));
    }
}
