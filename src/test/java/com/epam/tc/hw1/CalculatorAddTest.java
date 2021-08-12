package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.withPrecision;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

@Test(groups = {"addSub"})
public class CalculatorAddTest extends InitCalculator {

    @Test(dataProvider = "dataSetAddLong", dataProviderClass = CalculatorDataProviderClass.class)
    public void testSumCalculatorLong(long num1, long num2, long expected) {
        long actual = calculator.sum(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataSetAddDouble", dataProviderClass = CalculatorDataProviderClass.class)
    public void testSumCalculatorDouble(double num1, double num2, double expected) {
        double actual = calculator.sum(num1, num2);
        assertThat(actual).isEqualTo(expected, withPrecision(3d));
    }

}
