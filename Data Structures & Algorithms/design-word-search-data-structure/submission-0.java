class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Giống hệt insert của bài Trie
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // dfs: từ vị trí i trong word, đang đứng ở node, có khớp được phần còn lại không?
    private boolean dfs(String word, int i, TrieNode node) {
        // Base case: đã khớp hết chuỗi -> chỉ đúng nếu có từ kết thúc ở đây
        if (i == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(i);

        if (c == '.') {
            // CHÌA KHÓA: '.' -> thử mọi nhánh đang tồn tại
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, i + 1, child)) {
                    return true; // chỉ cần 1 nhánh khớp -> dừng sớm
                }
            }
            return false; // thử hết mà không nhánh nào khớp
        }

        // Ký tự thường -> đi thẳng 1 nhánh như Trie bình thường
        TrieNode next = node.children[c - 'a'];
        return next != null && dfs(word, i + 1, next);
    }
}