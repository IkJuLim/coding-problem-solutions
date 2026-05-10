class Solution {
    int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calc(root);
        return ret;
    }

    private int calc(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(calc(node.left), 0);
        int right = Math.max(calc(node.right), 0);

        ret = Math.max(ret, left + node.val + right);

        return Math.max(left, right) + node.val;
    }
}