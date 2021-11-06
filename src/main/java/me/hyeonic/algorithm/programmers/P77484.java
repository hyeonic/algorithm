package me.hyeonic.algorithm.programmers;

public class P77484 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int same = 0;
        for (int win_num : win_nums) {
            for (int lotto : lottos) {
                if (lotto == win_num) {
                    same++;
                }
            }
        }

        int zeroCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            }
        }

        if (same < 2) {
            answer[1] = 6;
        } else {
            answer[1] = 7 - same;
        }

        if (same + zeroCount < 2) {
            answer[0] = 6;
        } else {
            answer[0] = 7 - (same + zeroCount);
        }

        return answer;
    }

    public static void main(String[] args) {
        P77484 p77484 = new P77484();

        int[] solution = p77484.solution(
                new int[]{44, 1, 0, 0, 31, 25},
                new int[]{31, 10, 45, 1, 6, 19}
        );

        System.out.print("[");
        for (int i : solution) {
            System.out.print(i + " ");
        }
        System.out.print("]\n");

        solution = p77484.solution(
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{38, 19, 20, 40, 15, 25}
        );

        System.out.print("[");
        for (int i : solution) {
            System.out.print(i + " ");
        }
        System.out.print("]\n");

        solution = p77484.solution(
                new int[]{45, 4, 35, 20, 3, 9},
                new int[]{20, 9, 3, 45, 4, 35}
        );

        System.out.print("[");
        for (int i : solution) {
            System.out.print(i + " ");
        }
        System.out.print("]\n");
    }
}