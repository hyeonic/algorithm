package me.hyeonic.algorithm.baekjoon.silver3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1966 {

    static class Document {
        private int index;
        private int importance;

        public Document(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt(); // 문서의 개수
            int target = scanner.nextInt(); // 인쇄 순서를 알기위한 문서 index

            Queue<Document> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(new Document(i, scanner.nextInt()));
            }

            int count = 0;
            while (!queue.isEmpty()) {
                boolean isImportant = true;

                Document pollDocument = queue.poll();
                for (Document document : queue) {
                    // 자신 보다 중요한 문서가 있는 경우
                    if (pollDocument.importance < document.importance) {
                        isImportant = false;
                        break;
                    }
                }

                // 출력한 문서 index와 target이 같고 중요도가 가장 높은 경우
                if (pollDocument.index == target && isImportant) {
                    count++; // 출력
                    break;
                } else if (isImportant) { // 중요도만 높은 경우
                    count++; // 출력
                } else {
                    queue.add(pollDocument); // 가장 뒤로
                }
            }
            System.out.println(count);
        }
    }
}