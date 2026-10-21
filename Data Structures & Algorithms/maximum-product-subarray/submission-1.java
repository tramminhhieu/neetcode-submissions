class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0]; // tích lớn nhất của subarray kết thúc tại i
        int curMin = nums[0]; // tích nhỏ nhất của subarray kết thúc tại i
        int result = nums[0]; // đáp án toàn cục (không khởi tạo 0 vì đáp án có thể âm)

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // phải tính cả 2 ứng viên TRƯỚC khi ghi đè curMax/curMin
            int candidate1 = curMax * num;
            int candidate2 = curMin * num;

            // chìa khóa: số âm làm max và min đổi vai, nên xét cả hai
            curMax = Math.max(num, Math.max(candidate1, candidate2));
            curMin = Math.min(num, Math.min(candidate1, candidate2));

            result = Math.max(result, curMax);
        }
        return result;
    }
}