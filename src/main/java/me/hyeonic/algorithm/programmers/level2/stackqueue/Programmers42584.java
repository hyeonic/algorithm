package me.hyeonic.algorithm.programmers.level2.stackqueue;

public class Programmers42584 {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {

            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j])
                    ++count;
                else if (prices[i] > prices[j]) {
                    ++count;
                    break;
                }
            }

            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 2, 3, 2, 3});
        for (int i : solution) {
            System.out.print(i + " ");
        }

        System.out.println();

        solution = solution(new int[]{3, 2, 1, 2, 1});
        for (int i : solution) {
            System.out.print(i + " ");
        }

        System.out.println();

        solution = solution(new int[]{1, 2, 3, 4, 5});
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}