package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProviderClass {

    @DataProvider
    public static Object[][] dataSetAddLong() {
        return new Object[][]{{20, 20, 40}, {-50, 80, 30}, {90, -2_000, -1_910}};
    }

    @DataProvider
    public static Object[][] dataSetAddDouble() {
        return new Object[][]{{1.7, 111.4, 113.1}, {-10.11, 80.9, 70.79}, {90.88, -2_000.9, -1_910.02}};
    }

    @DataProvider
    public static Object[][] dataSetDivLong() {
        return new Object[][]{{25, 25, 1}, {50, 1, 50}, {100, 10_000, 0}};
    }

    @DataProvider
    public static Object[][] dataSetDivDouble() {
        return new Object[][]{{5, 25, 0.2}, {50, 1, 50}, {100, 10_000, 0.01}};
    }

    @DataProvider
    public static Object[][] dataSetMultLong() {
        return new Object[][]{{25, 25, 625}, {50, 1, 50}, {100, 10_000, 1_000_000}};
    }

    @DataProvider
    public static Object[][] dataSetMultDouble() {
        return new Object[][]{{25.5, 25.8, 657.9}, {50.31, 1, 50.31}, {100.144, 1_000.874, 100_231.526}};
    }

    @DataProvider
    public static Object[][] setDataSubLong() {
        return new Object[][]{{199, 99, 100}, {125_555, 5_555, 120_000}, {-90_000, 45_000, -135_000}};
    }

    @DataProvider
    public static Object[][] setDataSubDouble() {
        return new Object[][]{{199.55, 99.44, 100.11}, {125_555.987, 5_555.854, 120_000.133},
            {-90_000, 45_000.333, -135_000.333}};
    }

}
