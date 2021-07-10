package me.hyeonic.algorithm.old.programmers.kakao.blind2020;

import java.util.ArrayList;
import java.util.Arrays;

public class ColumnAndBeam_1 {

    static class Solution {
        int N;
        boolean[][][] obj; // obj[x][y][a] a: 0 기둥, 1 보

        boolean isColumn(int x, int y) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            return obj[x][y][0];
        }

        boolean isBeam(int x, int y) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            return obj[x][y][1];
        }

        boolean isInstalledColumn(int x, int y) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            if (y == N-1) return false;
            if (y>0 && !isColumn(x,y-1) && !isBeam(x-1,y) && !isBeam(x,y)) return false;
            return true;
        }

        boolean isInstalledBeam(int x, int y) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            if (y == 0 || x == N-1) return false;
            if (!isColumn(x,y-1) &&
                    !isColumn(x+1,y-1) &&
                    !(isBeam(x-1,y) && isBeam(x+1,y))) return false;
            return true;
        }

        boolean isReinstalled() {
            for (int x = 0; x < N; ++x)
                for (int y = 0; y < N; ++y) {
                    if (isColumn(x,y) && !isInstalledColumn(x,y)) return false;
                    if (isBeam(x,y) && !isInstalledBeam(x,y)) return false;
                }
            return true;
        }

        boolean isRemovedColumn(int x, int y) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            if (!isInstalledColumn(x,y)) return false;
            obj[x][y][0] = false;
            boolean result = isReinstalled();
            obj[x][y][0] = true;
            return result;
        }

        boolean isRemovedBeam(int x, int y) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            if (!isBeam(x,y)) return false;
            obj[x][y][1] = false;
            boolean result = isReinstalled();
            obj[x][y][1] = true;
            return result;
        }

        public int[][] solution(int n, int[][] build_frame) {
            N = n + 1;
            obj = new boolean[N][N][2];
            for (int[] c : build_frame) {
                int x = c[0], y = c[1], a = c[2], cmd = c[3];
                if (cmd == 1 && (a == 0 ? isInstalledColumn(x, y) : isInstalledBeam(x, y))) obj[x][y][a] = true;
                if (cmd == 0 && (a == 0 ? isRemovedColumn(x, y) : isRemovedBeam(x, y))) obj[x][y][a] = false;
            }
            ArrayList<int[]> list = new ArrayList<>();
            for (int x = 0; x < N; ++x)
                for (int y = 0; y < N; ++y)
                    for (int a = 0; a < 2; ++a)
                        if (obj[x][y][a]) list.add(new int[]{x, y, a});
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
