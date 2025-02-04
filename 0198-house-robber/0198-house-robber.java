class Solution {
  int[] dp;
  public int rob(int[] nums) {
    dp = new int[nums.length];
    Arrays.fill(dp, -1);
    int ret = 0;
    for (int i = 0; i < nums.length; i++) {
      ret = Math.max(ret, rob(nums, i));
    }

    return ret;
  }

  private int rob(int[] nums, int idx) {
    if (dp[idx] != -1) {
      return dp[idx];
    }
    int ret = 0;
    for (int i = idx + 2; i < nums.length; i++) {
      ret = Math.max(ret, rob(nums, i));
    }
    dp[idx] = ret + nums[idx];

    return dp[idx];
  }
}