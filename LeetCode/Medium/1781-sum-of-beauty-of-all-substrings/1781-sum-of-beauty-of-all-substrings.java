class Solution {
    public int beautySum(String s) {
        int ret = 0;
        for (int start = 0; start < s.length() - 1; start++) {
            int[] chars = new int[26];
            chars[s.charAt(start) - 'a']++;
            for (int end = start + 1; end < s.length(); end++) {
                chars[s.charAt(end) - 'a']++;
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (int i : chars) {
                    max = Math.max(i, max);
                    if (i != 0) min = Math.min(i, min);
                }
                ret += max - min;
            }
        }
        return ret;
    }
}