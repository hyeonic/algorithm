package me.hyeonic.algorithm.programmers.level1.sort;

public class Programmers42842 {

    public static int[] solution(int brown, int yellow) {

        int row = 0, col = 0;

        for (int i = 1; i <= yellow; i++) {
            row = i;
            col = yellow / i;

            if (brown == (row * 2 + col * 2 + 4) && row >= col) {
                break;
            }
        }

        int[] answer = new int[2];
        answer[0] = row + 2;
        answer[1] = col + 2;
        return answer;
    }

    public static void main(String[] args) {

        solution(10, 2);
        solution(8, 1);
        solution(24, 24);

    }
}
