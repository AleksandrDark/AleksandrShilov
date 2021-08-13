package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import org.testng.annotations.Test;

@Test(groups = {"multDiv"})
public class CalculatorMultiplyTest extends InitBaseCalculator {

    @Test(dataProvider = "dataSetMultLong", dataProviderClass = CalculatorDataProviderClass.class)
    public void testMultiply(long num1, long num2, long expected) {
        long actual = calculator.mult(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataSetMultDouble", dataProviderClass = CalculatorDataProviderClass.class)
    public void testMultiply(double num1, double num2, double expected) {
        double actual = calculator.mult(num1, num2);
        assertThat(actual).isEqualTo(expected, withPrecision(3d));
    }

}
