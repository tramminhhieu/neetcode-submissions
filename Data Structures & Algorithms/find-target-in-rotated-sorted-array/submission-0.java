class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Dùng left <= right: đây là binary search "tìm chính xác", phải xét cả khi còn 1 phần tử
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // Nửa trái [left..mid] đã sorted
                // Dấu <= quan trọng: khi left == mid thì nửa trái chỉ có 1 phần tử, vẫn coi là sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;   // target nằm trong nửa trái
                } else {
                    left = mid + 1;    // target ở nửa phải
                }
            } else {
                // Nửa phải [mid..right] đã sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;    // target nằm trong nửa phải
                } else {
                    right = mid - 1;   // target ở nửa trái
                }
            }
        }
        return -1;
    }
}