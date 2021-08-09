package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test(groups = {"multDiv"})
public class CalculatorDivideTest {

    private Calculator calculator;

    @BeforeMethod
    public void initCalculator(){
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] dataSetLong(){
        return new Object[][]{{25, 25, 1}, {50, 1, 50}, {100, 10_000, 0}};
    }

    @Test(dataProvider = "dataSetLong")
    public void testDivLong(long num1, long num2, long res){
        long actual = calculator.div(num1, num2);
        assertThat(actual).isEqualTo(res);
    }

    @DataProvider
    public static Object[][] dataSetDouble(){
        return new Object[][]{{5, 25, 0.2}, {50, 1, 50}, {100, 10_000, 0.01}};
    }

    @Test(dataProvider = "dataSetDouble")
    public void testDivDouble(double num1, double num2, double res){
        double actual = calculator.div(num1, num2);
        assertThat(actual).isEqualTo(res, withPrecision(3d));
    }

}
