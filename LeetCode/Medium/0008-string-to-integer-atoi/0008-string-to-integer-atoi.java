class Solution {
    public int myAtoi(String s) {
        long ret = 0;
        Boolean isNegative = null;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (isNegative != null) break;
                continue;
            }
            if (c == '-' && ret == 0) {
                if (isNegative != null) break;
                isNegative = true;
                continue;
            }
            if (c == '+' && ret == 0) {
                if (isNegative != null) break;
                isNegative = false;
                continue;
            }
            if (ret >= 2147483648L) {
                break;
            }
            if (c >= '0' && c <= '9') {
                if (isNegative == null) {
                    isNegative = false;
                }
                ret = (ret * 10 + (c - '0'));
                continue;
            }
            break;
        }
        if (isNegative == null) return 0;
        if (isNegative) ret *= -1;
        if (ret > Integer.MAX_VALUE) ret = Integer.MAX_VALUE;
        if (ret < Integer.MIN_VALUE) ret = Integer.MIN_VALUE;

        return (int)ret;
    }
}