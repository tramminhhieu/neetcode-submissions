class PrefixTree {

    // Mỗi node: 26 con (a-z) + cờ đánh dấu "có từ kết thúc tại đây"
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode(); // root không chứa ký tự nào
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';      // map 'a'..'z' -> 0..25
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode(); // chỉ tạo node khi chưa có -> tái sử dụng prefix chung
            }
            node = node.children[idx];
        }
        node.isEnd = true; // CHÌA KHÓA: đánh dấu kết thúc từ
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd; // phải tồn tại đường đi VÀ là điểm kết thúc từ
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;   // chỉ cần đường đi tồn tại
    }

    // Helper dùng chung: đi theo chuỗi s, trả về node cuối hoặc null nếu đứt giữa chừng
    private TrieNode findNode(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (node.children[idx] == null) return null;
            node = node.children[idx];
        }
        return node;
    }
}