package me.hyeonic.algorithm.old.programmers.level2.hash;

import java.io.IOException;

public class Programmers42577 {

    // 정확성: 83.3 효율성 8.3 합계: 91.7 / 100
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

    // 정확성: 83.3 효율성 8.3 합계: 91.7 / 100
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

    // 정확성: 83.3 효율성 8.3 합계: 91.7 / 100
    public static boolean solution3(String[] phoneBook) {

        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook.length; j++) {
                if (i != j) {
                    String sourcePhone = phoneBook[i];
                    int sourcePhoneLength = sourcePhone.length(); // 비교 기준 폰 번호 길이
                    int sourceHashCode = sourcePhone.hashCode(); // hashCode

                    String targetPhone = phoneBook[j]; // 비교 하려는 폰 번호 길이
                    if (targetPhone.length() >= sourcePhoneLength) {
                        targetPhone = targetPhone.substring(0, sourcePhoneLength);
                        int targetStrHashCode = targetPhone.hashCode();

                        // hashCode 비교
                        if (sourceHashCode == targetStrHashCode) return false;
                    }
                }
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
            System.out.println(solution3(phoneBook));
        }
    }
}