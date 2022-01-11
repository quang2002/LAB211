/*
 * Copyright 2022 QuangTDHE16060
 * https://github.com/quang2002
 */
package testjava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author chall
 */
public class TestJava {

    public static String toSentence(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }

        return Character.toUpperCase(s.charAt(0)) + (len == 1 ? "" : s.toLowerCase().substring(1));
    }

    public static void printReverse(String s) {
        final String NGAT_CAU = ".?!;";

        String[] sentences = s.split("[" + NGAT_CAU + "]\\s*");
        ArrayList<Character> abc = new ArrayList<>();

        for (Character c : s.toCharArray()) {
            //c.toString().matches("[.?!;]")
            if (NGAT_CAU.contains(c.toString())) {
                abc.add(c);
            }
        }

        int i = sentences.length - 1;
        int j = abc.size() - 1;

        if (s.endsWith(sentences[sentences.length - 1])) {
            // chữ trước
            while (i >= 0 || j >= 0) {
                if (i >= 0) {
                    System.out.print(toSentence(sentences[i].trim()));
                }

                if (j >= 0) {
                    System.out.print(abc.get(j) + " ");
                }

                i--;
                j--;
            }
        } else {
            // dấu trước 
            while (i >= 0 || j >= 0) {
                if (j >= 0) {
                    System.out.print(abc.get(j) + " ");
                }

                if (i >= 0) {
                    System.out.print(toSentence(sentences[i].trim()));
                }

                i--;
                j--;
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        printReverse(s);
    }

}
