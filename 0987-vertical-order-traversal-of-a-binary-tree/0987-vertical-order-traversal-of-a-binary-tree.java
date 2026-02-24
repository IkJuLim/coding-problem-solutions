class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int currC = 0;
        dfs(root, 0, 0);

        List<List<Integer>> ret = new LinkedList<>();

        List<Integer> keys = map.keySet().stream().sorted().toList();
        for (int key : keys) {
            ret.add(map.get(key).stream().sorted().toList());
        }

        return ret;
    }

    private void dfs(TreeNode node, int row, int col) {
        List<Integer> valList = map.getOrDefault(col, new LinkedList<>());
        valList.add(node.val);
        map.put(col, valList);
        if (node.left != null) {
            dfs(node.left, row+1, col-1);
        }
        if (node.right != null) {
            dfs(node.right, row+1, col+1);
        }
    }
}