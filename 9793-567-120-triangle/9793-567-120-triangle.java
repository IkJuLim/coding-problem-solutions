class Solution {
  int[][] dp = new int[201][201];

  public int minimumTotal(List<List<Integer>> triangle) {
    for (int i = 0; i < 201; i++) {
      for (int j = 0; j < 201; j++) {
        dp[i][j] = -10000;
      }
    }
    return dp(0, 0, triangle);
  }

  public int dp(int depth, int i, List<List<Integer>> triangle) {
    if (triangle.size()-1 == depth) {
      return triangle.get(depth).get(i);
    }
    if (dp[depth][i] != -10000){
      return dp[depth][i];
    }
    dp[depth][i] = triangle.get(depth).get(i) + Math.min(dp(depth + 1, i, triangle), dp(depth + 1, i + 1, triangle));
    return dp[depth][i];
  }
}