import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        ret.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (getGCD(ret.get(ret.size() - 1), nums[i]) != 1){
                ret.add(getLCM(ret.get(ret.size() - 1), nums[i]));
                ret.remove(ret.size() - 2);
                if (ret.size() > 1 && getGCD(ret.get(ret.size() - 2), ret.get(ret.size() - 1)) != 1){
                    postAdd(ret);
                }
            }else {
                ret.add(nums[i]);
            }
        }

        return ret;
    }
    private void postAdd(List<Integer> ret){
        while (ret.size() > 1 && getGCD(ret.get(ret.size() - 2), ret.get(ret.size() - 1)) != 1){
            ret.add(getLCM(ret.get(ret.size() - 2), ret.get(ret.size() - 1)));
            ret.remove(ret.size() - 2);
            ret.remove(ret.size() - 2);
        }
    }

    private static int getLCM(int num1, int num2) {
        int gcd = getGCD(num1, num2);
        int lcm = (int)(((long)num1 * num2) / getGCD(num1, num2));

        return lcm;
    }

    private static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}