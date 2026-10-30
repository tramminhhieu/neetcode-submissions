class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;  // phần nhớ, dịch sang trái 1 bit
            a = a ^ b;                 // tổng không tính nhớ
            b = carry;                 // lần sau cộng tiếp phần nhớ
        }
        return a;
    }
}