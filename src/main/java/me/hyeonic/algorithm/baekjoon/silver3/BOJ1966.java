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
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int target = scanner.nextInt();

            Queue<Document> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                queue.add(new Document(j, scanner.nextInt()));
            }

            int count = 0;
            while (!queue.isEmpty()) {
                boolean isImportant = true;

                Document pollDocument = queue.poll();
                for (Document document : queue) {
                    if (pollDocument.importance < document.importance) {
                        isImportant = false;
                    }
                }

                if (pollDocument.index == target && isImportant) {
                    count++;
                    break;
                } else if (isImportant) {
                    count++;
                } else {
                    queue.add(pollDocument);
                }
            }
            System.out.println(count);
        }
    }
}