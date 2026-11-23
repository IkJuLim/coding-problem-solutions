class Solution {
    public int divide(int a, int b) {
        long ret = 0;
        long dividend = a;
        long divisor = b;
        boolean isNeg = false;
        if (dividend < 0){
            dividend = -dividend;
            isNeg = !isNeg;
        }
        if (divisor < 0){
            divisor = -divisor;
            isNeg = !isNeg;
        }
        List<Long> divisors = new ArrayList<>();
        List<Long> steps = new ArrayList<>();

        divisors.add(divisor);
        steps.add(1l);
        long currDivisor = divisor;
        long currStep = 1l;

        do {
            divisors.add(currDivisor);
            steps.add(currStep);
            currDivisor += currDivisor;
            currStep += currStep;
        } while(currDivisor < dividend);

        int currIdx = divisors.size() - 1;
        while (dividend >= divisor) {
            while (currIdx >= 0 && dividend < divisors.get(currIdx)) {
                currIdx--;
            }
            dividend -= divisors.get(currIdx);
            ret += steps.get(currIdx);
        }

        ret = isNeg ? -ret : ret;
        if (ret > 2147483647) {
            ret = 2147483647;
        }
        return (int)ret;
    }
}