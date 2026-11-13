class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // index xa nhất có thể tới được tính đến hiện tại
        int lastIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            // Chìa khóa: ô i nằm ngoài vùng tới được → kẹt vĩnh viễn
            if (i > maxReach) return false;

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= lastIndex) return true; // dừng sớm
        }
        return true;
    }
}