class Solution {
    public String longestPalindrome(String s) {
        String best = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i + 1 > best.length() && isPalindrome(s, i, j)) {
                    best = s.substring(i, j + 1);
                }
            }
        }
        return best;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}