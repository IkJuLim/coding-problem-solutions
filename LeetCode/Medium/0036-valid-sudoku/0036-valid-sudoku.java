class Solution {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          for (int k = 0; k < 9; k++) {
            if (i != k && board[i][j] == board[k][j])
              return false;
          }
          for (int k = 0; k < 9; k++) {
            if (j != k && board[i][j] == board[i][k])
              return false;
          }
          for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
              if ((i != i / 3 * 3 + k && j != j / 3 * 3 + l) && board[i][j] == board[i / 3 * 3 + k][j / 3 * 3 + l])
                return false;
            }
          }
        }
      }
    }
    return true;
  }
}