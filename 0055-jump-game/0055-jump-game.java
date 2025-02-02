class Solution {
  boolean[] visited;
  public boolean canJump(int[] nums) {
    visited = new boolean[nums.length];
    return visit(0, nums);
  }

  private boolean visit(int idx, int[] nums) {
    if (idx >= nums.length || idx < 0 || visited[idx]) {
      return false;
    }
    if (idx == nums.length - 1) {
      return true;
    }
    
    visited[idx] = true;
    for (int i = 1; i <= nums[idx]; i++) {
      if (visit(idx + i, nums) || visit(idx - i, nums)) {
        return true;
      }
    }
    return false;
  }
}