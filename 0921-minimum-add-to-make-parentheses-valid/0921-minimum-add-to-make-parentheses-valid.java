class Solution {
    public int minAddToMakeValid(String s) {
        int cnt = 0, ret = 0;
        char curr = ')';
        for (char c : s.toCharArray()) {
            if (curr == c && cnt == 0) ret++;
            else cnt += (c == '(') ? 1 : -1;
            curr = c;
        }
        return ((cnt > 0) ? cnt : cnt * -1) + ret;
    }
}