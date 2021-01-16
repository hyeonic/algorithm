package me.hyeonic.algorithm.example.trie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void trieTest() {
        Trie trie = new Trie();

        // insert 메서드
        assertTrue(trie.isRootEmpty());
        trie.insert("PI");
        trie.insert("PIE");
        trie.insert("POW");
        trie.insert("POP");
        assertFalse(trie.isRootEmpty());

        // Contains 메서드
        assertTrue(trie.contains("POW"));
        assertFalse(trie.contains("PIES"));

        // Delete 메서드
        trie.delete("POP");
        assertFalse(trie.contains("POP"));
        assertTrue(trie.contains("POW"));

        // 없는 단어를 지울 때 > 에러발생하는 예
//        trie.delete("PO");
//        trie.delete("PIES");
//        trie.delete("PEN");
    }
}