class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int idx1 = m - 1, idx2 = n - 1, idxM = m + n - 1;
    while (idx2 >= 0) {
      if (idx1 < 0 || nums1[idx1] < nums2[idx2]) {
        nums1[idxM--] = nums2[idx2--];
      }
      else{
        nums1[idxM--] = nums1[idx1--];
      }
    }
  }
}