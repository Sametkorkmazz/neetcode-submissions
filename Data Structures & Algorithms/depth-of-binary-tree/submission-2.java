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
    record Entry(TreeNode node, int level) {}

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Stack<Entry> stack = new Stack<>();
        stack.push(new Entry(root, 1));
        int depth = 1;
        while (!stack.isEmpty()) {
            Entry node = stack.pop();
            if (node.node().left != null)
                stack.push(new Entry(node.node().left, node.level() + 1));
            if (node.node().right != null)
                stack.push(new Entry(node.node().right, node.level() + 1));
            depth = Math.max(depth, node.level());
        }
        return depth;
    }
}
