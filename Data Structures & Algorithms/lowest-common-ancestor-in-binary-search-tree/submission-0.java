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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val < cur.val && q.val < cur.val) {
                // Cả 2 nằm bên trái
                cur = cur.left;
            } else if (p.val > cur.val && q.val > cur.val) {
                // Cả 2 nằm bên phải
                cur = cur.right;
            } else {
                // p, q tách 2 phía, hoặc cur trùng với p hoặc q -> đây là LCA
                return cur;
            }
        }

        return null; // Không bao giờ tới đây vì p, q đảm bảo tồn tại
    }
}