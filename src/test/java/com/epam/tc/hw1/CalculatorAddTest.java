package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {"addSub"})
public class CalculatorAddTest {

    private Calculator calculator;

    @BeforeMethod
    public void initCalculator(){
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] dataSetLong(){
        return new Object[][]{{20, 20, 40}, {-50, 80, 30}, {90, -2_000, -1_910}};
    }

    @Test(dataProvider = "dataSetLong")
    public void testSumCalculatorLong(long num1, long num2, long expected){
        long actual = calculator.sum(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider
    public static Object[][] dataSetDouble(){
        return new Object[][]{{1.7, 111.4, 113.1}, {-10.11, 80.9, 70.79}, {90.88, -2_000.9, -1_910.02}};
    }

    @Test(dataProvider = "dataSetDouble")
    public void testSumCalculatorDouble(double num1, double num2, double expected){
        double actual = calculator.sum(num1, num2);
        assertThat(actual).isEqualTo(expected, withPrecision(3d));
    }

}
