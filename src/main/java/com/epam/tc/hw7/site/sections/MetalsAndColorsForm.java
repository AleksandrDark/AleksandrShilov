package com.epam.tc.hw7.site.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalAndColorEntity;

public class MetalsAndColorsForm extends Form<MetalAndColorEntity> {
    @JDropdown(root = "div#colors",
        value = ".filter-option",
        list = "li",
        expand = ".caret")
    public static Dropdown colors;
    @JDropdown(root = "div#metals",
        value = ".filter-option",
        list = "li",
        expand = ".caret")
    public static Dropdown metals;
    @UI("#elements-checklist input")
    public static Checklist elements;
    @JDropdown(root = "#vegetables",
        value = ".filter-option",
        list = "li",
        expand = ".caret")
    public Dropdown vegetables;
    @UI("[name=custom_radio_odd]")
    public RadioButtons summaryOdd;
    @UI("[name=custom_radio_even]")
    public RadioButtons summaryEven;
    @UI("button#submit-button")
    public Button submit;


    @Override
    public void fill(MetalAndColorEntity entity) {
        summaryOdd.select(entity.summary.get(0).toString());
        summaryEven.select(entity.summary.get(1).toString());
        entity.elements.forEach(elements::select);
        colors.select(entity.color);
        metals.select(entity.metals);
        vegetables.select("Vegetables");
        entity.vegetables.forEach(vegetables::select);
    }

    @Override
    public void submit() {
        submit.click();
    }
}
