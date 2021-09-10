package com.epam.tc.hw4.util;

import java.util.Arrays;
import org.testng.annotations.DataProvider;

public class DataProviderPage {

    @DataProvider
    public static Object[][] getTextPages() {
        return new Object[][]{
            {new DataProviderUtil("Home Page", "ROMAN IOVLEV", "frame",
                "value", "Frame Button", "Yellow",
                Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"),
                Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable", "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"),
                Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"),
                Arrays.asList("Yellow", "Selen", "Wind", "Water"),
                4, 4, 5)}};
    }
}
