class Solution {
  int[][] dp;
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        dp[i][j] = -1;
      }
    }
    dp[obstacleGrid.length - 1][obstacleGrid[obstacleGrid.length - 1].length - 1] = 1;
    return dp(obstacleGrid, 0, 0);
  }

  public int dp(int[][] obstacleGrid, int x, int y) {
    if (x == obstacleGrid.length || y == obstacleGrid[x].length || obstacleGrid[x][y] == 1) {
      return 0;
    }
    if (dp[x][y] != -1) {
      return dp[x][y];
    }
    dp[x][y] = dp(obstacleGrid, x + 1, y) + dp(obstacleGrid, x, y + 1);
    return dp[x][y];
  }
}