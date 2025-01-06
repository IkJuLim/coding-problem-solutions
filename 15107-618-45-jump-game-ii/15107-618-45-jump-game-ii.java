class Solution {
  int[] dp;
  static int INF = 999999999;
  public int jump(int[] nums) {
    dp = new int[nums.length];
    Arrays.fill(dp, -1);
    dp[nums.length-1] = 0;
    return dp(nums, 0);
  }

  public int dp(int[] nums, int idx) {
    if (dp[idx] != -1) {
      return dp[idx];
    }
    int min = INF;
    for (int i = idx + 1; i <= idx + nums[idx]; i++) {
      if (i == nums.length) {
        break;
      }
      min = Math.min(dp(nums, i), min);
    }
    dp[idx] = min + 1;
    return dp[idx];
  }
}