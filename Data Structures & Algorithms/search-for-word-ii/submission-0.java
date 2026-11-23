class Solution {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // != null nếu có từ kết thúc tại node này (thay cho isEnd)
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        // DFS bắt đầu từ mọi ô
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        // 1. Ra ngoài biên -> dừng
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;

        char ch = board[r][c];
        // 2. Ô đang nằm trên đường đi hiện tại -> không được dùng lại
        if (ch == '#') return;

        // 3. CHÌA KHÓA: Trie không có nhánh này -> không từ nào có prefix này -> cắt
        TrieNode node = parent.children[ch - 'a'];
        if (node == null) return;

        // 4. Tìm thấy 1 từ -> thêm vào, rồi xóa để không thêm trùng
        //    KHÔNG return ở đây: còn có thể có từ dài hơn (back -> backend)
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        // 5. Backtracking: đánh dấu -> thử 4 hướng -> khôi phục
        board[r][c] = '#';
        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);
        board[r][c] = ch;

        // 6. (Tối ưu thêm) Node đã hết từ và không còn con -> gỡ khỏi Trie
        //    để các lần DFS sau không đi vào nhánh "chết" này nữa
        if (node.word == null && isLeaf(node)) {
            parent.children[ch - 'a'] = null;
        }
    }

    private boolean isLeaf(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (int i = 0; i < w.length(); i++) {
                int idx = w.charAt(i) - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = w; // lưu nguyên từ
        }
        return root;
    }
}