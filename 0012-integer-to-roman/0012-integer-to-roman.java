class Solution {
  public String intToRoman(int num) {
    char[][] roman = {{'I', 'V'}, {'X', 'L'}, {'C', 'D'}, {'M', 'M'}};
    int[] nums = {num % 10, num % 100 / 10, num % 1000 / 100, num / 1000};
    StringBuilder sb = new StringBuilder();
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] == 9) {
        sb.append(roman[i][0]);
        sb.append(roman[i + 1][0]);
      } else if (nums[i] == 4) {
        sb.append(roman[i][0]);
        sb.append(roman[i][1]);
      } else {
        if (nums[i] >= 5) {
          sb.append(roman[i][1]);
          nums[i] -= 5;
        }
        for (; nums[i] > 0; nums[i]--) {
          sb.append(roman[i][0]);
        }
      }
    }
    return sb.toString();
  }
}