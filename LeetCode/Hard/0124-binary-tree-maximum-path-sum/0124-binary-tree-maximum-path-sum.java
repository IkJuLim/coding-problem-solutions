class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calcSum(root);
        return max;
    }

    private int calcSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = calcSum(node.left);
        int rightSum = calcSum(node.right);

        int currMax = Math.max(leftSum, rightSum) + node.val;
        max = Math.max(max, leftSum + node.val + rightSum);

        return Math.max(currMax, 0);
    }
}