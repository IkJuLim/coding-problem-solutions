class Solution {
    int ret;
    public int sumNumbers(TreeNode root) {
        ret = 0;
        calc(root, 0);
        return ret;
    }

    private void calc(TreeNode currNode, int currSum) {
        if (currNode == null) {
            return;
        }

        currSum = currSum * 10 + currNode.val;
        if (currNode.left == null && currNode.right == null) {
            ret += currSum;
            return;
        }

        calc(currNode.left, currSum);
        calc(currNode.right, currSum);
    }
}