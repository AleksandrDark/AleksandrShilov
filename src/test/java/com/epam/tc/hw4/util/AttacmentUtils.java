package com.epam.tc.hw4.util;

import io.qameta.allure.Attachment;

public class AttacmentUtils {

    @Attachment(type = "image/png", value = "use param {name}")
    public static byte[] makeScreenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
