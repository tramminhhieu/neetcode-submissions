class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // Hàng đầu và cột đầu: chỉ có 1 cách để đến
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // KEY: đến (i,j) chỉ có thể từ trên xuống hoặc từ trái sang
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}