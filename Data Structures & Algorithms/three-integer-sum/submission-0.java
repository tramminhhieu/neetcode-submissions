class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort để dùng Two Pointers và dễ skip trùng
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Mảng đã sort: nếu nums[i] > 0 thì 3 số từ đây trở đi đều dương, tổng không thể = 0
            if (nums[i] > 0) break;

            // Skip i trùng để tránh lặp triplet bắt đầu bằng cùng 1 giá trị
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // Skip các giá trị trùng liền kề để tránh triplet trùng
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // tổng còn nhỏ, cần tăng -> tăng left (mảng đã sort, tăng left làm sum tăng)
                } else {
                    right--; // tổng đang lớn, cần giảm -> giảm right
                }
            }
        }
        return result;
    }
}