class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] count = new int[128];          // ASCII: gồm cả chữ hoa và chữ thường
        for (char c : t.toCharArray()) {
            count[c]++;                      // count[c] > 0 nghĩa là còn cần ký tự c
        }

        int need = t.length();               // số ký tự (tính cả lặp) còn thiếu
        int left = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            if (count[rc] > 0) {
                need--;                      // ký tự này đang cần -> đã đáp ứng được 1
            }
            count[rc]--;                     // ký tự thừa/không thuộc t sẽ âm

            // Window đã đủ -> thu hẹp trái càng nhiều càng tốt
            while (need == 0) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                char lc = s.charAt(left);
                count[lc]++;
                if (count[lc] > 0) {
                    need++;                  // bỏ ký tự này thì window thiếu lại
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}