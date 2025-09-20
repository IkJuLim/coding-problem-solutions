class Solution {
  public int removeDuplicates(int[] nums) {
    int cnt = 0;
    for (int idx = 1; idx < nums.length; idx++) {
      if(nums[idx] != nums[cnt]){
        cnt++;
      }
      nums[cnt] = nums[idx];
    }

    return cnt+1;
  }
}