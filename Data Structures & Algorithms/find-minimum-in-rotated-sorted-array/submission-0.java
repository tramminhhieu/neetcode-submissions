class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Dùng left < right (không phải <=): dừng khi còn đúng 1 phần tử, đó chính là min
        while (left < right) {
            // Tránh overflow so với (left + right) / 2
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // mid nằm ở đoạn trái (đoạn lớn), nên min ở hẳn bên phải mid
                left = mid + 1;
            } else {
                // mid..right đang tăng dần, nên mid có thể là min và không được bỏ mid
                right = mid;
            }
        }
        return nums[left];
    }
}