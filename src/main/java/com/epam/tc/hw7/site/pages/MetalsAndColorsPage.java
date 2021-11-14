package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.site.sections.MetalsAndColorsForm;
import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    @Css("form")
    public static MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results li")
    private static List<UIElement> resultTab;

    public static List<String> getResult() {
        return resultTab.stream()
            .map(UIElement::getText)
            .collect(Collectors.toList());
    }
}
