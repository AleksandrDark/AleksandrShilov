package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {"addSub"})
public class CalculatorSubtractTest {

    private Calculator calculator;

    @BeforeMethod
    public void initCalculator(){
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] setDataLong(){
        return new Object[][]{{199, 99, 100}, {125_555, 5_555, 120_000}, {-90_000, 45_000, -135_000}};
    }

    @Test(dataProvider = "setDataLong")
    public void testSubtractLong(long num1, long num2, long expected){
        long actual = calculator.sub(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider
    public Object[][] setDataDouble(){
        return new Object[][]{{199.55, 99.44, 100.11}, {125_555.987, 5_555.854, 120_000.133}, {-90_000, 45_000.333, -135_000.333}};
    }

    @Test(dataProvider = "setDataDouble")
    public void testSubtractDouble(double num1, double num2, double expected){
        double actual = calculator.sub(num1, num2);
        assertThat(actual).isEqualTo(expected, withPrecision(3d));
    }

}
