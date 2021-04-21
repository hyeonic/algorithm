package meimport java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon10974 {

    static int[] output;
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.valueOf(bufferedReader.readLine());
        int[] array = new int[n];
        output = new int[n];
        visited = new boolean[n];

        dfs(0);

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}.hyeonic.algorithm.baekjoon;

