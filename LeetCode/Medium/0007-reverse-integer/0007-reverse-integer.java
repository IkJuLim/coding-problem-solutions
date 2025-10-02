class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        int ret = 0;
        if(isNegative) {
            x *= -1;
        }

        while (x != 0) {
            int overflowCheck = ret * 10 + x % 10;

            if ((overflowCheck - x % 10) / 10 != ret) {
                return  0;
            }

            ret = overflowCheck;
            x /= 10;
        }
        return (isNegative ? -1 : 1) * ret;
    }
}