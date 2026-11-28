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
    record Pair(TreeNode p, TreeNode q) {}

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(p, q));
        while (!queue.isEmpty()) {
            int level = queue.size();
            Pair pair = queue.poll();
            TreeNode a = pair.p(), b = pair.q();
            if (a == null && b == null)
                continue;
            if (a == null || b == null || a.val != b.val) {
                return false;
            }

            queue.offer(new Pair(a.left, b.left));
            queue.offer(new Pair(a.right, b.right));
        }
        return true;
    }
}
