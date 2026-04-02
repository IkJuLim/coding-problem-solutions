class Solution {
    int ret;
    public int sumNumbers(TreeNode root) {
        ret = 0;
        dfs(root, 0);
        return ret;
    }

    private void dfs(TreeNode currNode, int currSum) {
        if (currNode == null) {
            return;
        }

        currSum = currSum * 10 + currNode.val;
        if (currNode.left == null && currNode.right == null) {
            ret += currSum;
            return;
        }

        dfs(currNode.left, currSum);
        dfs(currNode.right, currSum);
    }
}