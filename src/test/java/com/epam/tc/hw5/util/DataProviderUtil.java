package com.epam.tc.hw5.util;

import java.util.List;

public class DataProviderUtil {
    private final String title;
    private final String username;
    private final String idFrame;
    private final String buttonAttribute;
    private final String buttonName;
    private final List<String> expectedTextListElements;
    private final List<String> expectedTextUnderImages;
    private final List<String> expectedTextOnSidebarMenuLeft;
    private final String yellow;
    private final List<String> expectedContentInLogs;
    private final int countSidebarMenuLeft;
    private final int countImagesOnPage;
    private final int countElementsOnHeaderSection;

    public DataProviderUtil(
        String title, String username, String idFrame, String buttonAttribute, String buttonName, String yellow,
        List<String> expectedTextListElements, List<String> expectedTextUnderImages,
        List<String> expectedTextOnSidebarMenuLeft, List<String> expectedContentInLogs,
        int countElementsOnHeaderSection, int countImagesOnPage, int countSidebarMenuLeft) {

        this.title = title;
        this.username = username;
        this.idFrame = idFrame;
        this.buttonAttribute = buttonAttribute;
        this.buttonName = buttonName;
        this.yellow = yellow;
        this.expectedTextListElements = expectedTextListElements;
        this.expectedTextUnderImages = expectedTextUnderImages;
        this.expectedTextOnSidebarMenuLeft = expectedTextOnSidebarMenuLeft;
        this.expectedContentInLogs = expectedContentInLogs;
        this.countElementsOnHeaderSection = countElementsOnHeaderSection;
        this.countImagesOnPage = countImagesOnPage;
        this.countSidebarMenuLeft = countSidebarMenuLeft;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getExpectedTextListElements() {
        return expectedTextListElements;
    }

    public List<String> getExpectedTextUnderImages() {
        return expectedTextUnderImages;
    }

    public String getButtonAttribute() {
        return buttonAttribute;
    }

    public String getButtonName() {
        return buttonName;
    }

    public List<String> getExpectedTextOnSidebarMenuLeft() {
        return expectedTextOnSidebarMenuLeft;
    }

    public String getIdFrame() {
        return idFrame;
    }

    public String getColor() {
        return yellow;
    }

    public List<String> getExpectedContentInLogs() {
        return expectedContentInLogs;
    }

    public int getCountSidebarMenuLeft() {
        return countSidebarMenuLeft;
    }

    public int getCountImagesOnPage() {
        return countImagesOnPage;
    }

    public int getCountElementsOnHeaderSection() {
        return countElementsOnHeaderSection;
    }
}
