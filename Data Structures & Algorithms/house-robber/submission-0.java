class Solution {
    public int rob(int[] nums) {
        int prev2 = 0; // tối đa tính đến nhà i-2
        int prev1 = 0; // tối đa tính đến nhà i-1

        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num); // bỏ qua hoặc cướp nhà này
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
