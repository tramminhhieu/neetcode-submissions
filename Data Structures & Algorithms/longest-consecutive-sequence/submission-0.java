class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            // Chỉ bắt đầu đếm nếu num là ĐIỂM KHỞI ĐẦU của 1 dãy
            if (!set.contains(num - 1)) {
                int length = 1;
                int current = num;
                // Đếm dần lên: num+1, num+2, ... miễn còn tồn tại trong set
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}