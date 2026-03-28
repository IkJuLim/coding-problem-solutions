class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int idx1 = 0; idx1 < nums.length - 3; idx1++) {
            if (idx1 != 0 && nums[idx1] == nums[idx1 - 1]){
                continue;
            }
            for (int idx2 = idx1 + 1; idx2 < nums.length - 2; idx2++) {
                if (idx2 != idx1 + 1 && nums[idx2] == nums[idx2 - 1]){
                    continue;
                }
                int start = idx2 + 1, end = nums.length - 1;
                long tar = (long) target - nums[idx1] - nums[idx2];
                while (start < end) {
                    if (tar == nums[start] + nums[end]) {
                        ret.add(List.of(nums[idx1], nums[idx2], nums[start], nums[end]));
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (tar > nums[start] + nums[end]) {
                        start++;
                    } else if (tar < nums[start] + nums[end]) {
                        end--;
                    }
                }
            }
        }
        return ret;
    }
}