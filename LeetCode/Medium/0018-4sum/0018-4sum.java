class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ret = new HashSet<>();
        for (int idx1 = 0; idx1 < nums.length - 3; idx1++) {
            for (int idx2 = idx1 + 1; idx2 < nums.length - 2; idx2++) {
                int start = idx2 + 1, end = nums.length - 1;
                long tar = (long) target - nums[idx1] - nums[idx2];
                while (start < end) {
                    if (tar == nums[start] + nums[end]) {
                        ret.add(List.of(nums[idx1], nums[idx2], nums[start], nums[end]));
                        end--;
                    } else if (tar > nums[start] + nums[end]) {
                        start++;
                    } else if (tar < nums[start] + nums[end]) {
                        end--;
                    }
                }
            }
        }
        return ret.stream().toList();
    }
}