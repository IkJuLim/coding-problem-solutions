class Solution {
    List<TreeNode> ret;
    Map<String, Integer> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ret = new ArrayList<>();
        map = new HashMap();

        dfs(root);
        
        return ret;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        String pathStr = root.val + "(" + dfs(root.left) + ")(" + dfs(root.right) + ")";
        map.put(pathStr, map.getOrDefault(pathStr, 0) + 1);
        if (map.get(pathStr) == 2) {
            ret.add(root);
        }
        return pathStr;
    }
}