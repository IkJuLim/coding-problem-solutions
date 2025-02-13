class Solution {
  public List<String> summaryRanges(int[] nums) {
    StringBuilder sb = new StringBuilder();
    List<String> ret = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (sb.length() == 0) {
        sb.append(nums[i]);
      }
      if (i != nums.length - 1 && nums[i + 1] == nums[i] + 1) {
        continue;
      }
      if (!sb.toString().equals(Integer.valueOf(nums[i]).toString())) {
        sb.append("->");
        sb.append(nums[i]);
      }
      ret.add(sb.toString());
      sb.delete(0, sb.length() );
    }
    return ret;
  }
}