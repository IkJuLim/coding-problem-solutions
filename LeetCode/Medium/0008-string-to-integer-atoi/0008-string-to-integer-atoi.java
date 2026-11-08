class Solution {
    public int myAtoi(String s) {
        long ret = 0;
        int sign = 0;
        Boolean isNegative = null;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (sign != 0) break;
                continue;
            }
            if (c == '-' && ret == 0) {
                if (sign != 0) break;
                sign = -1;
                continue;
            }
            if (c == '+' && ret == 0) {
                if (sign != 0) break;
                sign = 1;
                continue;
            }
            if (ret >= 2147483648L) {
                break;
            }
            if (c >= '0' && c <= '9') {
                if (sign == 0) {
                    sign = 1;
                }
                ret = (ret * 10 + (c - '0'));
                continue;
            }
            break;
        }
        if (sign == 0) return 0;
        ret *= sign;
        if (ret > Integer.MAX_VALUE) ret = Integer.MAX_VALUE;
        if (ret < Integer.MIN_VALUE) ret = Integer.MIN_VALUE;

        return (int)ret;
    }
}