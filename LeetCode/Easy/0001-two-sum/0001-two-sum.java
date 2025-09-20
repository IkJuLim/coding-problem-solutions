class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      Integer remainder = map.get(target - nums[i]);
      if (remainder != null && remainder != i)
        return new int[]{i, remainder};
    }
    return null;
  }
}