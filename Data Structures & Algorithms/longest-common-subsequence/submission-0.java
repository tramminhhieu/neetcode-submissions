class Solution {
    private int[][] memo;
    private char[] s1, s2;

    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1.toCharArray();
        s2 = text2.toCharArray();
        memo = new int[s1.length + 1][s2.length + 1];
        for (int[] row : memo) java.util.Arrays.fill(row, -1); // -1 = chưa tính
        return solve(s1.length, s2.length);
    }

    private int solve(int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        if (s1[i - 1] == s2[j - 1]) {
            memo[i][j] = 1 + solve(i - 1, j - 1);
        } else {
            memo[i][j] = Math.max(solve(i - 1, j), solve(i, j - 1));
        }
        return memo[i][j];
    }
}