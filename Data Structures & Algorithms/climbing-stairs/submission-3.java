class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // số cách đến bậc i = từ i-1 nhảy 1, hoặc từ i-2 nhảy 2
        }

        return dp[n];
    }
}