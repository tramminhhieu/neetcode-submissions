public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >>> i) & 1;       // lấy bit thứ i (tính từ phải, 0-indexed)
            result |= (bit << (31 - i));   // đặt bit đó vào vị trí đối xứng (31 - i)
        }
        return result;
    }
}