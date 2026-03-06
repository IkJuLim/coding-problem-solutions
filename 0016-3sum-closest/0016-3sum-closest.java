class Solution {
    public int threeSumClosest(int[] nums, int target) {
        long ret = (long)Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    ret = (Math.abs(target - ret) > Math.abs(target - sum) ? sum : ret);
                }
            }
        }

        return (int)ret;
    }
}