class Solution {
    private int rows, cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        // Thử bắt đầu từ mọi ô
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) return true;            // đã khớp đủ word
        if (r < 0 || c < 0 || r >= rows || c >= cols         // ra ngoài lưới
                || board[r][c] != word.charAt(index)) {      // không khớp hoặc ô đã dùng ('#')
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';                                   // choose: đánh dấu đã dùng

        boolean found = dfs(board, word, r + 1, c, index + 1)
                     || dfs(board, word, r - 1, c, index + 1)
                     || dfs(board, word, r, c + 1, index + 1)
                     || dfs(board, word, r, c - 1, index + 1); // explore 4 hướng

        board[r][c] = temp;                                  // un-choose: khôi phục
        return found;
    }
}