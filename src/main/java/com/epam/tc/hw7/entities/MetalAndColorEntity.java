package com.epam.tc.hw7.entities;

import static java.lang.String.format;
import static java.lang.String.join;

import com.jdiai.tools.DataClass;
import java.util.ArrayList;
import java.util.List;

public class MetalAndColorEntity extends DataClass<MetalAndColorEntity> {
    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    public List<String> getExpectedMetalAndColorElements() {
        List<String> expectedElements = new ArrayList<>();
        expectedElements.add(format("Summary: %s", summary.get(0) + summary.get(1)));
        expectedElements.add(format("Elements: %s", join(", ", elements)));
        expectedElements.add(format("Color: %s", color));
        expectedElements.add(format("Metal: %s", metals));
        expectedElements.add(format("Vegetables: %s", join(", ", vegetables)));
        return expectedElements;
    }
}
