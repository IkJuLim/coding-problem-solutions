class Solution {
  public int uniquePaths(int m, int n) {
    int[][]cnt = new int[m][n];
    for (int i = 0; i < m; i++) {
      cnt[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      cnt[0][i] = 1;
    }

    for (int i = 2; i < m + n - 1; i++) {
      for (int j = 1; j < i; j++) {
        if (i - j >= m || j >= n) {
          continue;
        }
        cnt[i - j][j] = cnt[i - j - 1][j] + cnt[i - j][j - 1];
      }
    }

    return cnt[m - 1][n - 1];
  }
}