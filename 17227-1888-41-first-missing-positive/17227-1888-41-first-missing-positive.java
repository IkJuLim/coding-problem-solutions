class Solution {
  boolean[] arr = new boolean[100001];
  public int firstMissingPositive(int[] nums) {
    for (int num : nums) {
      if(num > 0 && num <= 100000){
        arr[num] = true;
      }
    }
    for (int i = 1; i < 100001; i++) {
      if (!arr[i]) {
        return i;
      }
    }
    return 100001;
  }
}