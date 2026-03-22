class Solution {
    List<List<String>> ret;
    public List<List<String>> solveNQueens(int n) {
        ret = new ArrayList<>();
        makeRet(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new ArrayList<>());

        return ret;
    }

    private void makeRet(int n, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> revDiags, List<Integer> queensCol) {
        if (row == n) {
            addRetString(n, queensCol);
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, cols, diags, revDiags)) {
                cols.add(col);
                diags.add(row + col);
                revDiags.add(row - col);
                queensCol.add(col);
                makeRet(n, row + 1, cols, diags, revDiags, queensCol);
                cols.remove(col);
                diags.remove(row + col);
                revDiags.remove(row - col);
                queensCol.removeLast();
            }
        }
    }

    private void addRetString(int n, List<Integer> queensCol) {
        ArrayList<String> list = new ArrayList<>();
        for (int queenCol : queensCol) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append((i != queenCol) ? '.' : 'Q');
            }
            list.add(sb.toString());
        }
        ret.add(list);
    }

    private boolean isValid(int row, int col, Set<Integer> cols, Set<Integer> diags, Set<Integer> revDiags) {
        if (cols.contains(col)) {
            return false;
        }
        if (diags.contains(row + col)) {
            return false;
        }
        if (revDiags.contains(row - col)) {
            return false;
        }
        return true;
    }
}
