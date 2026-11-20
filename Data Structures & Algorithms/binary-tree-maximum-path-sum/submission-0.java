class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        // Khởi tạo bằng MIN_VALUE (không phải 0) vì cây có thể toàn node âm
        maxSum = Integer.MIN_VALUE;
        gain(root);
        return maxSum;
    }

    // Trả về tổng lớn nhất của đường đi "một nhánh" bắt đầu từ node và đi xuống
    private int gain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Nhánh nào âm thì bỏ (coi như đóng góp 0)
        int leftGain = Math.max(0, gain(node.left));
        int rightGain = Math.max(0, gain(node.right));

        // Đường đi "bẻ cong" tại node này: dùng cả 2 nhánh -> cập nhật đáp án
        int pathThroughNode = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, pathThroughNode);

        // Trả lên cho cha: chỉ được chọn 1 nhánh
        return node.val + Math.max(leftGain, rightGain);
    }
}