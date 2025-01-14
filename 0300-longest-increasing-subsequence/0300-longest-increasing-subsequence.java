class Solution {
  List<Integer> LIS;
  public int lengthOfLIS(int[] nums) {
    LIS = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int idx = BinarySearch(nums, nums[i], 0, LIS.size()-1);
      if (idx == -1) {
        LIS.add(nums[i]);
      } else {
        LIS.set(idx, nums[i]);
      }
    }

    return LIS.size();
  }

  private int BinarySearch(int[] nums, int num, int start, int end) {
    int ret = 0;
    while (start <= end) {
      int mid = (start + end) / 2;

      if (num <= LIS.get(mid)) {
        ret = mid;
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }

    if (start == LIS.size()) {
      return -1;
    }
    return ret;
  }
}