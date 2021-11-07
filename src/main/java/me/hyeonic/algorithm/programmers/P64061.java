package me.hyeonic.algorithm.programmers;

import java.util.Stack;

public class P64061 {

    public int solution(int[][] board, int[] moves) {

        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int k = board[i][move - 1];

                if (k == 0) {
                    continue;
                }

                if (!stack.isEmpty() && stack.peek() == k) {
                    stack.pop();
                    answer++;
                } else {
                    stack.push(k);
                }

                board[i][move - 1] = 0;
                break;
            }
        }

        return answer * 2;
    }

    public static void main(String[] args) {
        P64061 p64061 = new P64061();

        System.out.println(p64061.solution(new int[][]{
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}},
                new int[]{1,5,3,5,1,2,1,4}
        ));
    }
}