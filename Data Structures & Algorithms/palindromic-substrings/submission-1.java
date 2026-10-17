class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);       // tâm là ký tự i (palindrome lẻ)
            count += expand(s, i, i + 1);   // tâm là khoảng giữa i và i+1 (palindrome chẵn)
        }
        return count;
    }

    // Trả về số palindrome có tâm tại (left, right)
    private int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;   // chìa khóa: mỗi lần mở rộng thành công = 1 palindrome mới
            left--;
            right++;
        }
        return count;
    }
}