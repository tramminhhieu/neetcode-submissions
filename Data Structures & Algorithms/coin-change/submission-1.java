class Solution {
    public int coinChange(int[] coins, int amount) {
        // dùng amount + 1 làm "vô cực": số xu tối đa chỉ có thể là amount (toàn xu mệnh giá 1)
        // nên amount + 1 không bao giờ là đáp án thật, và cộng 1 vào không bị overflow
        int INF = amount + 1;
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, INF);
        dp[0] = 0; // tạo 0 đồng cần 0 xu

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) { // bỏ qua xu lớn hơn i (tránh index âm)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}