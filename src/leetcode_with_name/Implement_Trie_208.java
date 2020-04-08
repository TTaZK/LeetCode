package leetcode_with_name;

public class Implement_Trie_208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("test");
        System.out.println(trie.search("testr"));
        System.out.println(trie.startsWith("tet"));
    }
}

class TrieNode {
    char key;
    // 每个节点存在26个子节点
    TrieNode[] children = new TrieNode[26];
    boolean isWord;

    public TrieNode(char key) {
        this.key = key;
    }

    public TrieNode() {

    }
}

class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                TrieNode child = new TrieNode(c);
                temp.children[c - 'a'] = child;
            }
            // temp 肯定不会为空
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return temp.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (char c : prefix.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return true;
    }
}
