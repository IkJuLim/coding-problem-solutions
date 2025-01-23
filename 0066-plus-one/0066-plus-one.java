class Solution {
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] != 9) {
        digits[i]++;
        break;
      }
      if (i == 0) {
        int[] ret = new int[digits.length + 1];
        ret[0] = 1;
        return ret;
      }
      digits[i] = 0;
    }
    return digits;
  }
}