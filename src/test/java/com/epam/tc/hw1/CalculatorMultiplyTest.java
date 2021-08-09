package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {"multDiv"})
public class CalculatorMultiplyTest {

    private Calculator calculator;

    @BeforeMethod
    public void initCalculator(){
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] dataSetLong(){
        return new Object[][]{{25, 25, 625}, {50, 1, 50}, {100, 10_000, 1_000_000}};
    }

    @DataProvider
    public static Object[][] dataSetDouble(){
        return new Object[][]{{25.5, 25.8, 657.9}, {50.31, 1, 50.31}, {100.144, 1_000.874, 100_231.526}};
    }

    @Test(dataProvider = "dataSetLong")
    public void testMultiply(long num1, long num2, long expected){
        long actual = calculator.mult(num1, num2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataSetDouble")
    public void testMultiply(double num1, double num2, double expected){
        double actual = calculator.mult(num1, num2);
        assertThat(actual).isEqualTo(expected, withPrecision(3d));
    }





}
