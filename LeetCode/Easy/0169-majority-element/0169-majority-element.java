class Solution {
  public int majorityElement(int[] nums) {
    int ret = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      if (map.get(num) > nums.length / 2) {
        return num;
      }
    }
    return ret;
  }
}