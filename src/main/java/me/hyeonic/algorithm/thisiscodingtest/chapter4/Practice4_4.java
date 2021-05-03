package me.hyeonic.algorithm.thisiscodingtest.chapter4;

import java.util.Scanner;

public class Practice4_4 {

    public static int n, m, x, y, d;
    public static int[][] map; // 전체 맵 정보
    public static boolean[][] visited; //방문한 위치를 저장하기 위한 맵
    public static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서 방향
    public static int[] dy = {0, 1, 0, -1}; // 북 동 남 서 방향

    private static void turnLeft() {
        d -= 1;
        if (d == -1) d = 3;
    }

    private static boolean isLocation(int x, int y) {
        if (map[x][y] == 0 && !visited[x][y]) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];

        x = sc.nextInt(); // 현재 캐릭터의 좌표 x
        y = sc.nextInt(); // 현재 캐릭터의 좌표 y
        d = sc.nextInt(); // 현재 방향
        visited[x][y] = true; // 현재 좌표 방문 처리

        // 전체 맵 정보 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int cnt = 1;
        int turnCnt = 0;
        while (true) {
            turnLeft();
            int nextX = x + dx[d];
            int nextY = y + dy[d];
            if (isLocation(nextX, nextY)) { // 회전 이후 정면에 가보지 않은 칸이 존재한다면 이동
                visited[nextX][nextY] = true;
                x = nextX;
                y = nextY;
                cnt++;
                turnCnt = 0;
                continue;
            } else {
                turnCnt++;
            }

            if (turnCnt == 4) {
                nextX = x - dx[d];
                nextY = y - dy[d];
                if (map[nextX][nextY] == 0) {
                    x = nextX;
                    y = nextY;
                } else break;
                turnCnt = 0;
            }
        }

        System.out.println(cnt);
    }
}

/*
input
4 4         # 4 x 4 맵 생성
1 1 0       # (1, 1)에 북쪽(0)을 바라보고 있는 캐릭터
1 1 1 1     # 바다/바다/바다/바다
1 0 0 1     # 바다/육지/육지/바다
1 1 0 1     # 바다/바다/육지/바다
1 1 1 1     # 바다/바다/바다/바다

4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1

ouput
3
*/