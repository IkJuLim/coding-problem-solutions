class Solution {
  public int smallestDivisor(int[] nums, int threshold) {
    int l = 0, r = (int)1e6;
    while (l < r) {
      int mid = (l + r) / 2;
      int sum1 = getSum(nums, mid);
      int sum2 = getSum(nums, mid + 1);

      if (sum1 > threshold && sum2 <= threshold) {
        return mid + 1;
      }

      if (sum1 <= threshold) {
        r = mid;
      } else {
        l = mid;
      }
    }
    return 0;
  }

  int getSum(int [] nums, int divisor) {
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += Math.ceil((double)nums[i] / (double)divisor);
    }
    System.out.println(divisor + " : " + sum);
    return sum;
  }
}