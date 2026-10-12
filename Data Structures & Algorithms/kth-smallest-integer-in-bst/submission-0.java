/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // Đi hết sang trái, đẩy các node trên đường đi vào stack
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // Lấy node trái nhất chưa thăm ra "thăm"
            cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val; // node thứ k -> dừng ngay
            }

            // Sau khi thăm gốc, chuyển sang subtree phải
            cur = cur.right;
        }

        return -1; // không bao giờ tới đây vì k luôn hợp lệ
    }
}