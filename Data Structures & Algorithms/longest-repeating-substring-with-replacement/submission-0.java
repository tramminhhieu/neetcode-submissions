class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];   // mảng đếm thay cho HashMap vì chỉ có 26 chữ in hoa
        int left = 0, maxFreq = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            count[idx]++;
            maxFreq = Math.max(maxFreq, count[idx]);

            // Chìa khóa: số ký tự cần đổi = độ dài window - maxFreq
            // Nếu vượt quá k thì thu hẹp window từ bên trái
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}