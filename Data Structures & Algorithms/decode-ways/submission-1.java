class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // chuỗi rỗng: 1 cách

        for (int i = 1; i <= n; i++) {
            // Trường hợp 1: ký tự thứ i đứng một mình
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // Trường hợp 2: ghép ký tự i-1 và i thành số 10..26
            if (i >= 2) {
                int two = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                if (two >= 10 && two <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}