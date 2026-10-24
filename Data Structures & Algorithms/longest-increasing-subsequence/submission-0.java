class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1); // mỗi phần tử tự nó là một dãy độ dài 1

        int result = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {              // ngặt: dùng <, không phải <=
                    dp[i] = Math.max(dp[i], dp[j] + 1); // nối nums[i] vào sau dãy kết thúc tại j
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}