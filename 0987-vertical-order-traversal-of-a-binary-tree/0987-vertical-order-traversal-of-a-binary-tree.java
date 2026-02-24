class Solution {
    HashMap<Integer, List<List<Integer>>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        List<List<Integer>> ret = new LinkedList<>();

        List<Integer> keys = map.keySet().stream().sorted().toList();
        for (int key : keys) {
            ret.add(map.get(key).stream()
                    .flatMap(innerList -> innerList.stream().sorted())
                    .collect(Collectors.toList()));
        }

        return ret;
    }

    private void dfs(TreeNode node, int row, int col) {
        List<List<Integer>> valList = map.getOrDefault(col, new LinkedList<>());
        while (valList.size() - 1 < row) {
            valList.add(new LinkedList<>());
        }
        valList.get(row).add(node.val);
        map.put(col, valList);
        if (node.left != null) {
            dfs(node.left, row+1, col-1);
        }
        if (node.right != null) {
            dfs(node.right, row+1, col+1);
        }
    }
}