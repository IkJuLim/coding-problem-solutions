class Solution {
    public int countBinarySubstrings(String s) {
        int ret = 0;
        char curr = s.charAt(0);
        int cnt = 0;
        int prevCnt = 0;
        for (char c : s.toCharArray()) {
            if (curr == c) {
                cnt++;
            } else {
                ret += Math.min(cnt, prevCnt);
                prevCnt = cnt;
                cnt = 1;
                curr = c;
            }
        }
        ret += Math.min(cnt, prevCnt);
        return ret;
    }
}