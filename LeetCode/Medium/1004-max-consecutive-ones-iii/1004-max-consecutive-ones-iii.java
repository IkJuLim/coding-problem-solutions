class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, cnt = 0, ret = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (nums[start] == 0) {
                    cnt--;
                }
                start++;
            }
            ret = Math.max(ret, end - start + 1);

            end++;
        }
        return ret;
    }
}