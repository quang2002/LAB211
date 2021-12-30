/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package Utilities;

/**
 *
 * @author yuyu
 */
public class StringHelper {

    public static String center(int row, Object obj) {
        String text = obj.toString();
        if (text.length() > row) {
            return text.substring(0, row - 3).concat("...");
        }

        final int spaces = row - text.length();
        return String.format("%" + (spaces / 2) + "s%s%" + (spaces - spaces / 2) + "s", "", text, "");
    }
}
