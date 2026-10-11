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
    private Long prev = null; // dùng Long để phân biệt "chưa có giá trị trước"

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;

        if (!inorder(node.left)) return false;

        // Phải lớn hơn NGHIÊM NGẶT giá trị trước đó
        if (prev != null && node.val <= prev) return false;
        prev = (long) node.val;

        return inorder(node.right);
    }
}
