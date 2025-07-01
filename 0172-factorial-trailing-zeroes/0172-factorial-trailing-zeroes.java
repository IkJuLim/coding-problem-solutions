class Solution {
    public int trailingZeroes(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i++){
            int tmp = i;
            while(tmp != 0 && tmp % 5 == 0){
                tmp /= 5;
                ret++;
            }
        }
        return ret;
    }
}