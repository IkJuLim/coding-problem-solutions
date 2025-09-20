class Solution {
  List<List<String>> res;
  public List<List<String>> solveNQueens(int n) {
    res = new ArrayList<>();

    List<List<Integer>> queens = new ArrayList<>();
    recallII(n, queens, 0);

    return res;
  }

  private void recallII(int n, List<List<Integer>> queens, int x) {
    if (x >= n && queens.size() == n) {
      List<String> sl = new ArrayList<>();
      for (List<Integer> queen : queens) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
          sb.append(i == queen.get(1) ? 'Q' : '.');
        }

        sl.add(sb.toString());
      }
      res.add(sl);
      return;
    }
    for (int y = 0; y < n; y++) {
      if (isPossible(queens, x, y)) {
        queens.add(List.of(x, y));
        recallII(n, queens, x + 1);
        queens.remove(queens.size() - 1);
      }
    }
  }

  private boolean isPossible(List<List<Integer>> queens, int x, int y) {
    for (List<Integer> queen : queens) {
      if (queen.get(1) == y || queen.get(1) - queen.get(0) == y - x || queen.get(1) + queen.get(0) == y + x)
        return false;
    }
    return true;
  }
}