class Solution {
  int[][] dp = new int[201][201];
  static int INF = 999999999;
  public int minPathSum(int[][] grid) {
    for (int i = 0; i < 201; i++){
      for (int j = 0; j < 201; j++){
        dp[i][j] = INF;
      }
    }
    return minPathSum(0, 0, grid);
  }

  public int minPathSum(int y, int x, int[][] grid) {
    if (grid.length == y || grid[0].length == x) {
      return INF;
    }
    if (grid.length-1 == y && grid[0].length-1 == x) {
      return grid[y][x];
    }
    if (dp[y][x] != INF){
      return dp[y][x];
    }
    dp[y][x] = grid[y][x] + Math.min(minPathSum(y + 1, x, grid), minPathSum(y, x + 1, grid));
    return dp[y][x];
  }
}