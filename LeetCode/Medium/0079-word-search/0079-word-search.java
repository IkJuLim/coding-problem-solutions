class Solution {
  boolean answer = false;
  boolean[][] visited;
  int m, n;

  public boolean exist(char[][] board, String word) {
    m = board.length;
    n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == word.charAt(0) && !answer) {
          visited = new boolean[m][n];
          check(i, j, 0, board, word);
        }
      }
    }
    return answer;
  }

  void check(int r, int c, int index, char[][] board, String word) {
    if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
      return;
    }
    if (board[r][c] != word.charAt(index)) {
      return;
    }
    if (index == word.length() - 1 && board[r][c] == word.charAt(index)) {
      answer = true;
      return;
    }
    visited[r][c] = true;
    check(r + 1, c, index + 1, board, word);
    check(r - 1, c, index + 1, board, word);
    check(r, c + 1, index + 1, board, word);
    check(r, c - 1, index + 1, board, word);
    visited[r][c] = false;
  }
}