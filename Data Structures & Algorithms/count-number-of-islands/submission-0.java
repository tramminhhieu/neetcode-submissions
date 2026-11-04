class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;              // gặp đất chưa thăm → một đảo mới
                    sinkIsland(grid, r, c); // dìm cả đảo để không đếm lại
                }
            }
        }
        return count;
    }

    private void sinkIsland(char[][] grid, int r, int c) {
        // KIỂM TRA BIÊN TRƯỚC rồi mới truy cập grid[r][c]
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
                || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0'; // đánh dấu đã thăm NGAY, trước khi gọi đệ quy

        sinkIsland(grid, r + 1, c);
        sinkIsland(grid, r - 1, c);
        sinkIsland(grid, r, c + 1);
        sinkIsland(grid, r, c - 1);
    }
}