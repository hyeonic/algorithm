package me.hyeonic.algorithm.old.programmers.kakao.blind2021;


public class Programmers72410 {

    public static String solution(String new_id) {

        // 1단계
        String step1 = new_id.toLowerCase();
        System.out.println("step1 " + step1);

        // 2단계
        char[] chars = step1.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for (char c : chars) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                step2.append(c);
            }
        }
        System.out.println("step2 " + step2.toString());

        // 3단계
        String step3 = step2.toString();
        while (step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }
        System.out.println("step3 " + step3);

        // 4단계
        String step4 = step3;
        if (step4.length() >= 1) {
            if (step4.charAt(0) == '.') {
                step4 = step4.substring(1);
            }
        }
        if (step4.length() >= 1) {
            if (step4.charAt(step4.length() - 1) == '.') {
                step4 = step4.substring(0, step4.length() - 1);
            }
        }
        System.out.println("step4 " + step4);

        // 5단계
        String step5 = step4;
        if (step5.isEmpty()) {
            step5 = "a";
        }
        System.out.println("step5 " + step5);

        // 6단계
        String step6 = step5;
        if (step6.length() >= 16) {
            step6 = step6.substring(0, 15);
        }

        if (step6.charAt(step6.length() - 1) == '.') {
            step6 = step6.substring(0, 14);
        }

        System.out.println("step6 " + step6);

        // 7단계
        StringBuilder step7 = new StringBuilder(step6);
        while (step7.length() <= 2) {
            step7.append(step7.charAt(step7.length() - 1));
        }
        System.out.println("step7 " + step7.toString());

        return step7.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution(	"=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }
}