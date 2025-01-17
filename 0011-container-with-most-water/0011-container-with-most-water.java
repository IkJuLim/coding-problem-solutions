class Solution {
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1, max = 0, area;
    while (left < right) {
      if (height[right] > height[left]) {
        area = height[left] * (right - left);
        left++;
      }else {
        area = height[right] * (right - left);
        right--;
      }
      if (area > max) {
        max = area;
      }
    }
    return max;
  }
}