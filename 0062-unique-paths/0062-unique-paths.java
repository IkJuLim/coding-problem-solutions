class Solution {
  int[][] dp;
  
  public int uniquePaths(int m, int n) {
    dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    
    for (int i = 2; i < m + n - 1; i++) {
      for (int j = 1; j < i; j++) {
        if (i - j >= m || j >= n) {
          continue;
        }
        dp[i - j][j] = dp[i - j - 1][j] + dp[i - j][j - 1];
      }
    }
    
    return dp[m - 1][n - 1];
  }
}