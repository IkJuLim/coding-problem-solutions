class Solution {
  public int removeElement(int[] nums, int val) {
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      if (nums[start] == val) {
        int tmp = nums[end];
        nums[end] = nums[start];
        nums[start] = tmp;
        end--;
      } else {
        start++;
      }
    }
    return start;
  }
}