package com.shevart.androidcorelearn.different_test_tasks.test_task_1.util;

import android.support.annotation.NonNull;

import java.util.Locale;

import static com.shevart.androidcorelearn.utils.Util.isNullOrEmpty;

@SuppressWarnings("WeakerAccess")
public class XMLParserUtil {
    private static final String START_TAG_PATTERN = "<%s>";
    private static final String END_TAG_PATTERN = "</%s>";

    public static boolean isContainsElementByTagName(@NonNull String xml, @NonNull String elementName) {
        return xml.contains(prepareStartTag(elementName))
                && xml.contains(prepareEndTag(elementName));
    }

    public static String removeFirstIntervalElement(@NonNull String s, @NonNull String element) {
        if (!isContainsElementByTagName(s, element))
            throw new IllegalArgumentException();

        String endTag = prepareEndTag(element);
        return s.substring(s.indexOf(endTag) + endTag.length());
    }

    public static String retrieveFirstElementContent(@NonNull String xml,
                                                     @NonNull String elementName) {
        if (isNullOrEmpty(xml) || isNullOrEmpty(elementName))
            throw new IllegalArgumentException();

        String startTag = prepareStartTag(elementName);
        return xml.substring(xml.indexOf(startTag) + startTag.length(),
                xml.indexOf(prepareEndTag(elementName)));
    }

    public static int parseInt(@NonNull String xml, @NonNull String elementName) {
        String elementContent = retrieveFirstElementContent(xml, elementName).trim();
        return Integer.valueOf(elementContent);
    }

    private static String prepareStartTag(@NonNull String tag) {
        return String.format(Locale.ENGLISH, START_TAG_PATTERN, tag);
    }

    private static String prepareEndTag(@NonNull String tag) {
        return String.format(Locale.ENGLISH, END_TAG_PATTERN, tag);
    }
}
