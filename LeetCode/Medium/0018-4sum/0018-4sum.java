class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ret = new HashSet<>();
        for (int start1 = 0; start1 < nums.length; start1++) {
            int end1 = nums.length - 1;
            while (start1 < end1) {
                int start2 = start1 + 1, end2 = end1 - 1;
                long tar2 = (long) target - nums[start1] - nums[end1];
                System.out.println("tar2 = " + tar2);
                while (start2 < end2) {
                    if (tar2 == nums[start2] + nums[end2]) {
                        ret.add(List.of(nums[start1], nums[start2], nums[end1], nums[end2]));
                        end2--;
                    } else if (tar2 > nums[start2] + nums[end2]) {
                        start2++;
                    } else if (tar2 < nums[start2] + nums[end2]) {
                        end2--;
                    }
                }
                end1--;
            }
        }
        return ret.stream().toList();
    }
}