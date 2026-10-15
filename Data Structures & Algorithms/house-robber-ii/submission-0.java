class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // tránh trường hợp tách mảng ra rỗng

        // TH1: bỏ nhà cuối [0, n-2]; TH2: bỏ nhà đầu [1, n-1]
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    // House Robber I trên đoạn [start, end]
    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0; // tối đa tính đến nhà i-2
        int prev1 = 0; // tối đa tính đến nhà i-1

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]); // bỏ qua hoặc cướp nhà i
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}