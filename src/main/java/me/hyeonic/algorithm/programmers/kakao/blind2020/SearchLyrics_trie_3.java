package me.hyeonic.algorithm.programmers.kakao.blind2020;

public class SearchLyrics_trie_3 {

    static class Node {
        int count;
        Node[] nodes;

        public void add(String word, int index) {
            ++count;
            if (index == word.length()) return;         // index 가 범위를 벗어났다.
            if (nodes == null) nodes = new Node[26];    // 알파벳 숫자 만큼 자식 노드를 만든다.
            int c = word.charAt(index) - 'a';           // word 에서 index 위치 문자가 'a' 이면 0 번째
            // 'b' 이면 1 번째, 'c' 이면 2 번째 자식 노드이어야 한다.
            if (nodes[c] == null) nodes[c] = new Node();
            nodes[c].add(word, index + 1);
        }

        public void print(String s) {
            if (nodes != null) {                                // 아직 leaf 노드가 아니다.
                for (int i = 0; i < nodes.length; i++)          // 자식 노드 재귀 호출 해야 한다.
                    if (nodes[i] != null)
                        nodes[i].print(s + (char)('a' + i));    // 현재 노드의 문자를 더해서, 자식 노드 재귀호출

                System.out.printf("중간: %s %d\n", s, count);    // 중간노드의 자식 leaf 의 수 출력
            } else // leaf
                System.out.println("leaf: " + s); // leaf 이다. 단어가 하나 완성되었다.
        }
    }

    static Node[] roots = new Node[10000]; // 최대 단어 길이 10000, index 범위는 0 ~ 9999
    // 단어 길이 마다 trie 트리를 따로 만든다.
    static void add(String word) {
        int i = word.length() - 1; // 단어 길이 -1을 index 로 한다 (0 ~ 9999)
        if (roots[i] == null) roots[i] = new Node(); // 그 위치에 trie 루트 노드가 없다면 만든다.

        roots[i].add(word, 0);
    }

    static void print() {
        for (Node root : roots)
            if (root != null) root.print("");
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        for (String word : words) {
            add(word);
        }
        print();
    }
}