class Solution {
    public int maxSubArray(int[] nums) {
        // Khởi tạo bằng nums[0], KHÔNG phải 0, để xử lý đúng mảng toàn số âm
        int currentSum = nums[0]; // tổng lớn nhất của subarray KẾT THÚC tại i
        int maxSum = nums[0];     // đáp án tốt nhất tính đến hiện tại

        for (int i = 1; i < nums.length; i++) {
            // Chìa khóa: nối tiếp đoạn cũ, hay bắt đầu lại từ nums[i]?
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}