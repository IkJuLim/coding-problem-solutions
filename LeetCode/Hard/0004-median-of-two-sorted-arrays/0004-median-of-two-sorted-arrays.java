class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int len = (nums1.length + nums2.length + 1) / 2,
                l1 = 0, r1 = nums1.length;
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;

        if (nums1.length == 0) {
            if (isEven) {
                return (double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2;
            }
            return nums2[nums2.length/2];
        }
        
        while (l1 <= r1) {
            int nums1Idx = (l1 + r1) / 2;
            int nums2Idx = len - ((l1 + r1) / 2);

            int maxNum1L = nums1Idx - 1 >= 0 ? nums1[nums1Idx - 1] : Integer.MIN_VALUE;
            int minNum1R = nums1Idx < nums1.length ? nums1[nums1Idx] : Integer.MAX_VALUE;
            int maxNum2L = nums2Idx - 1 >= 0 ? nums2[nums2Idx - 1] : Integer.MIN_VALUE;
            int minNum2R = nums2Idx < nums2.length ? nums2[nums2Idx] : Integer.MAX_VALUE;

            if (minNum2R >= maxNum1L && minNum1R >= maxNum2L) {
                if (isEven) {
                    return ((Math.max(maxNum1L, maxNum2L) + Math.min(minNum1R, minNum2R)) / 2.0);
                } else {
                    return Math.max(maxNum1L, maxNum2L);
                }
            } else if (minNum2R < maxNum1L) {
                r1 = nums1Idx - 1;
            } else if (minNum1R < maxNum2L) {
                l1 = nums1Idx + 1;
            }
        }
        return 0.0;
    }
}