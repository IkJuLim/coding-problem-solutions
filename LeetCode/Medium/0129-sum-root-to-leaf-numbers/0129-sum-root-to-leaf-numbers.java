import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int sumNumbers(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                node.left.val = node.val * 10 + node.left.val;
                q.add(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val * 10 + node.right.val;
                q.add(node.right);
            }
            if(node.right == null && node.left == null) {
                ret += node.val;
            }
        }

        return ret;
    }
}