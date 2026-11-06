class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Xuất phát từ các ô biên: cột trái/phải
        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);          // cột 0 → Pacific
            dfs(heights, atlantic, r, cols - 1);  // cột cuối → Atlantic
        }
        // Xuất phát từ các ô biên: hàng trên/dưới
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);          // hàng 0 → Pacific
            dfs(heights, atlantic, rows - 1, c);  // hàng cuối → Atlantic
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    // Đi NGƯỢC dòng: chỉ bước sang ô kề CAO HƠN HOẶC BẰNG ô hiện tại
    private void dfs(int[][] heights, boolean[][] reachable, int r, int c) {
        if (reachable[r][c]) return;   // đã thăm từ biển này rồi
        reachable[r][c] = true;

        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];
            if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length) continue;
            if (heights[nr][nc] >= heights[r][c]) {   // điều kiện ĐẢO CHIỀU
                dfs(heights, reachable, nr, nc);
            }
        }
    }
}