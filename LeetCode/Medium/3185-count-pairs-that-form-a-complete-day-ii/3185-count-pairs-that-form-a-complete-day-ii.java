class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long ret = 0;
        long[] nums = new long[24];
        for (int hour : hours) {
            hour %= 24;
            nums[hour]++;
        }
        for (int i = 1; i < 12; i++) {
            ret += nums[i] * nums[24 - i];
        }
        if (nums[0] >= 2) {
            ret += (nums[0] * (nums[0] - 1)) /2;
        }
        if (nums[12] >= 2) {
            ret += (nums[12] * (nums[12] - 1)) /2;
        }
        return ret;
    }
}