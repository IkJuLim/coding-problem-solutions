class Solution {
    List<Integer> path = new LinkedList<>();

    public int pathSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return ret;
        }
        path.add(root.val);
        long sum = 0L;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) ret++;
        }

        if (root.right != null) {
            ret += pathSum(root.right, targetSum);
        }
        if (root.left != null) {
            ret += pathSum(root.left, targetSum);
        }
        path.remove(path.size() - 1);

        return ret;
    }
}