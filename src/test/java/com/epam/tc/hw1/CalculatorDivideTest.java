package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Test(groups = {"multDiv"})
public class CalculatorDivideTest extends InitCalculator {

    @Test(dataProvider = "dataSetDivLong", dataProviderClass = CalculatorDataProviderClass.class)
    public void testDivLong(long num1, long num2, long res) {
        long actual = calculator.div(num1, num2);
        assertThat(actual).isEqualTo(res);
    }

    @Test(dataProvider = "dataSetDivDouble", dataProviderClass = CalculatorDataProviderClass.class)
    public void testDivDouble(double num1, double num2, double res) {
        double actual = calculator.div(num1, num2);
        assertThat(actual).isEqualTo(res, withPrecision(3d));
    }

}
