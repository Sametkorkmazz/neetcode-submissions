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
    record Entry(boolean balanced, int depth) {}
    public boolean isBalanced(TreeNode root) {
        Entry res = dfs(root);
        return res.balanced();
    }
    public Entry dfs(TreeNode root) {
        if (root == null)
            return new Entry(true, 0);
        Entry left = dfs(root.left), right = dfs(root.right);
        boolean balanced =
            left.balanced() && right.balanced() && Math.abs(left.depth() - right.depth()) <= 1;
        return new Entry(balanced, Math.max(left.depth(), right.depth()) + 1);
    }
}
