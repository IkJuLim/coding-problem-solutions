class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ret = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if(tmp == null) continue;
            q.add(tmp.left);
            q.add(tmp.right);
            if(tmp.val >= low && tmp.val <= high) ret += tmp.val;
        }

        return ret;
    }
}