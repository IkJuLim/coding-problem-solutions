class Solution {
  public int[] twoSum(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    int[] result = new int[2];

    while(l < r) {
      int sum = nums[l] + nums[r];
      if(sum == target) {
        result[0] = l;
        result[1] = r;
        break;
      } else if (sum < target) {
        l++;
      } else {
        r--;
      }
    }
    return result;
  }
}