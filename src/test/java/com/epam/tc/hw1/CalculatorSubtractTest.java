package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"addSub"})
public class CalculatorSubtractTest {

    private Calculator calculator;

    @BeforeMethod
    public void initCalculator() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "setDataSubLong", dataProviderClass = CalculatorDataProviderClass.class)
    public void testSubtractLong(long num1, long num2, long expected) {
        long actual = calculator.sub(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "setDataSubDouble", dataProviderClass = CalculatorDataProviderClass.class)
    public void testSubtractDouble(double num1, double num2, double expected) {
        double actual = calculator.sub(num1, num2);
        assertThat(actual).isEqualTo(expected, withPrecision(3d));
    }

}
