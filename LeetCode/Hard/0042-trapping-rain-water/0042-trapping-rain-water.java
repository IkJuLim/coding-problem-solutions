class Solution {
  public int trap(int[] height) {
    int ret = 0;
    int prev_max = 0;
    for (int i = 0; i < height.length; i++) {
      if (height[prev_max] <= height[i]) {
        int min = Math.min(height[prev_max], height[i]);
        for (int j = prev_max + 1; j < i; j++) {
          ret += min - height[j];
          System.out.println(j + " : " + (min - height[j]));
        }
        prev_max = i;
      }
    }

    prev_max = height.length-1;
    for (int i = height.length - 1; i >= 0; i--) {
      if (height[prev_max] < height[i]) {
        int min = Math.min(height[prev_max], height[i]);
        for (int j = prev_max - 1; j > i; j--) {
          ret += min - height[j];
          System.out.println(j + " : " + (min - height[j]));
        }
        prev_max = i;
      }
    }

    return ret;
  }
}