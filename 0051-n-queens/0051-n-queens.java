class Solution {
    List<List<String>> ret;
    public List<List<String>> solveNQueens(int n) {
        ret = new ArrayList<>();
        List<List<Integer>> queens = new ArrayList<>();
        recall(n, queens, 0);

        return ret;
    }

    private void recall(int n, List<List<Integer>> queens, int row) {
        if (row >= n && queens.size() == n) {
            List<String> sl = getStrings(n, queens);
            ret.add(sl);
        }
        for (int col = 0; col < n; col++) {
            if (isPosable(queens, row, col)) {
                queens.add(List.of(row, col));
                recall(n, queens, row + 1);
                queens.removeLast();
            }
        }
    }

    private static List<String> getStrings(int n, List<List<Integer>> queens) {
        List<String> sl = new ArrayList<>();
        for (int row = 0; row < queens.size(); row++) {
            List<Integer> queen = queens.get(row);
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (queen.get(0) == row && queen.get(1) == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            sl.add(sb.toString());
        }
        return sl;
    }

    private boolean isPosable(List<List<Integer>> queens, int row, int col) {
        for (List<Integer> queen : queens) {
            if (queen.get(0) == row ||
                    queen.get(1) == col ||
                    queen.get(0) + queen.get(1) == row + col ||
                    queen.get(0) - queen.get(1) == row - col)
                return false;
        }
        return true;
    }

}
