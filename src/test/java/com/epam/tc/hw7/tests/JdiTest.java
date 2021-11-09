package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.site.JdiTestSite.headerMenu;
import static com.epam.tc.hw7.site.JdiTestSite.metalsAndColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.userName;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.getResult;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.metalsAndColorsForm;
import static com.epam.tc.hw7.util.JdiDataProvider.EXPECTED_USERNAME;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw7.entities.MetalAndColorEntity;
import com.epam.tc.hw7.util.JdiDataProvider;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class JdiTest implements InitTest {

    @Test
    public void testLogin() {
        Assertions.assertThat(userName.getText()).as("User name is wrong")
            .isEqualTo(EXPECTED_USERNAME);
    }

    @Test(dataProvider = "testDataSet", dataProviderClass = JdiDataProvider.class)
    public void testMetalAndColorsSubmission(MetalAndColorEntity metalAndColorEntity) {
        headerMenu.select("Metals & Colors");
        metalsAndColorsPage.checkOpened();
        metalsAndColorsForm.fill(metalAndColorEntity);
        metalsAndColorsForm.submit();
        assertThat(getResult())
            .isEqualTo(metalAndColorEntity.getExpectedMetalAndColorElements());
    }
}
