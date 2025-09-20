class Solution {
  public int removeDuplicates(int[] nums) {
    int start = 2, end = nums.length;
    while (start < end) {
      if (nums[start] == nums[start - 1] && nums[start] == nums[start - 2]) {
        for (int i = start; i < end - 1; i++) {
          nums[i] = nums[i + 1];
        }
        end--;
      }
      else {
        start++;
      }
    }
    return end;
  }
}