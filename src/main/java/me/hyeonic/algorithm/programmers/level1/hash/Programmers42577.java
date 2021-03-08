package me.hyeonic.algorithm.programmers.level1.hash;

import java.io.IOException;

public class Programmers42577 {

    public static boolean solution1(String[] phoneBook) {

        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook.length; j++) {
                if (i != j) {
                    if (phoneBook[i].length() <= phoneBook[j].length()) {
                        String substring = phoneBook[j].substring(0, phoneBook[i].length());
                        if (substring.equals(phoneBook[i])) return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean solution2(String[] phoneBook) {

        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook.length; j++) {
                if (i != j)
                    if (phoneBook[j].startsWith(phoneBook[i]))
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        String[][] phoneBooks = {
                {"119", "97674223", "1195524421"},
                {"123","456","789"},
                {"12","123","1235","567","88"}
        };

        for (String[] phoneBook : phoneBooks) {
            System.out.println(solution2(phoneBook));
        }
    }
}