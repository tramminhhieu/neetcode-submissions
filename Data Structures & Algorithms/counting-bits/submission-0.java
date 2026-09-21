class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int x = i, count = 0;
            while (x != 0) {
                x &= (x - 1);   // Brian Kernighan
                count++;
            }
            output[i] = count;
        }
        return output;
    }
}