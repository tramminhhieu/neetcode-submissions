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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Cây rỗng thì không thể chứa subRoot (trừ khi subRoot cũng rỗng,
        // nhưng theo constraint subRoot có ít nhất 1 node nên không cần lo case đó)
        if (root == null) {
            return false;
        }

        // Thử: cây con tại node hiện tại có giống hệt subRoot không?
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Nếu không, thử tiếp ở subtree trái hoặc subtree phải
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Hàm phụ trợ tái sử dụng từ bài Same Binary Tree
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
