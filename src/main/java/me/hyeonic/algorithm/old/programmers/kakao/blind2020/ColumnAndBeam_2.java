package me.hyeonic.algorithm.old.programmers.kakao.blind2020;

import java.util.ArrayList;
import java.util.Arrays;

public class ColumnAndBeam_2 {

    static class Solution {
        static final int column = 0, beam = 1;
        int N;
        boolean[][][] obj; // obj[x][y][a] a: 0 기둥, 1 보

        boolean isColumnOrBeam(int x, int y, int a) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            return obj[x][y][a];
        }

        boolean isInstalled(int x, int y, int a) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            if (a == column) {
                if (y == N - 1) return false;
                if (y > 0 && !isColumnOrBeam(x,y - 1, column)
                        && !isColumnOrBeam(x - 1, y , beam)
                        && !isColumnOrBeam(x, y, beam)) return false;
            }
            else if (a == beam) {
                if (y == 0 || x == N - 1) return false;
                if (!isColumnOrBeam(x, y - 1, column)
                        && !isColumnOrBeam(x + 1,y - 1, column)
                        && !(isColumnOrBeam(x - 1, y, beam)
                        && isColumnOrBeam(x + 1, y, beam))) return false;
            }
            return true;
        }

        boolean isReinstalled() {
            for (int x = 0; x < N; ++x)
                for (int y = 0; y < N; ++y)
                    for (int a = 0; a < 2; ++a)
                        if (isColumnOrBeam(x, y, a) && !isInstalled(x, y, a)) return false;
            return true;
        }

        boolean isRemoved(int x, int y, int a) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            if (!isColumnOrBeam(x, y, a)) return false;
            obj[x][y][a] = false;
            boolean result = isReinstalled();
            obj[x][y][a] = true;
            return result;
        }

        public int[][] solution(int n, int[][] build_frame) {
            N = n + 1;
            obj = new boolean[N][N][2];
            for (int[] c : build_frame) {
                int x = c[0], y = c[1], a = c[2], cmd = c[3];
                if (cmd == 1 && isInstalled(x, y, a)) obj[x][y][a] = true;
                if (cmd == 0 && isRemoved(x, y, a)) obj[x][y][a] = false;
            }
            ArrayList<int[]> list = new ArrayList<>();
            for (int x = 0; x < N; ++x)
                for (int y = 0; y < N; ++y)
                    for (int a = 0; a < 2; ++a)
                        if (obj[x][y][a]) list.add(new int[] {x, y, a});
            return list.toArray(new int[0][]);
        }
    }

    public static void main(String[] args) {
        int[][] input1 = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},
                {5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] input2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},
                {3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};

        System.out.println(Arrays.deepToString(new Solution().solution(5, input1)));
        System.out.println(Arrays.deepToString(new Solution().solution(5, input2)));
    }
}