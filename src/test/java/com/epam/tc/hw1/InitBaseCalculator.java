package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class InitBaseCalculator {

    protected Calculator calculator;

    @BeforeMethod(groups = {"multDiv", "addSub"})
    public void initCalculator() {
        calculator = new Calculator();
    }
}
