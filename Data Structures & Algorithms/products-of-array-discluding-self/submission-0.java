class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Bước 1: res[i] = tích tất cả phần tử BÊN TRÁI i
        res[0] = 1; // không có phần tử nào bên trái i=0
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Bước 2: nhân thêm tích tất cả phần tử BÊN PHẢI i
        int suffix = 1; // không có phần tử nào bên phải i=n-1
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix *= nums[i];
        }

        return res;
    }
}