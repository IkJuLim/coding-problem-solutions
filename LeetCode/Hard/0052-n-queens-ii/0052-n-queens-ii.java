class Solution {
  int ret = 0;
  public int totalNQueens(int n) {
    Stack<List<Integer>> queens = new Stack<>();
    recall(n, queens, 0);
    return ret;
  }

  private void recall(int n, Stack<List<Integer>> queens, int x) {
    if (x >= n && queens.size() == n) {
      ret++;
      return;
    }
    for (int y = 0; y < n; y++) {
      if (isPossible(queens, x, y)) {
        queens.push(List.of(x, y));
        recall(n, queens, x + 1);
        queens.pop();
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