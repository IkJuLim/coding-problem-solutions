class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> ret = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 1; i < nums.length-1; i++) {
      int l = 0, r = nums.length - 1;
      while (l < i && r > i) {
        int sum = nums[l] + nums[i] + nums[r];
        if (sum == 0) {
          ret.add(Arrays.asList(nums[l], nums[i], nums[r]));
          r--;
        } else if (sum > 0) {
          r--;
        } else {
          l++;
        }
      }

    }
    
    return new ArrayList<>(ret);
  }
}