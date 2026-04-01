class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        calc(root, targetSum - root.val, path);
        return ret;
    }

    public void calc(TreeNode node, int target, List<Integer> path){
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(List.copyOf(path));
        }
        if (node.left != null) {
            path.add(node.left.val);
            calc(node.left, target - node.left.val, path);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            path.add(node.right.val);
            calc(node.right, target - node.right.val, path);
            path.remove(path.size() - 1);
        }
    }
}