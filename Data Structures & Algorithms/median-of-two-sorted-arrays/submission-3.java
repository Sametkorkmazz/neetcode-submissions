class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1.length > nums2.length ? nums2 : nums1;
        int[] B = nums1.length <= nums2.length ? nums2 : nums1;
        int totalLen = A.length + B.length;
        int l = 0;
        int r = A.length;

        while (l <= r) {
            int mA = (r + l) / 2;
            int mB = (totalLen + 1) / 2 - mA;

            int leftA = (mA == 0) ? Integer.MIN_VALUE : A[mA - 1];
            int rightA = (mA == A.length) ? Integer.MAX_VALUE : A[mA];
            int leftB = (mB == 0) ? Integer.MIN_VALUE : B[mB - 1];
            int rightB = (mB == B.length) ? Integer.MAX_VALUE : B[mB];

            if (leftA <= rightB && leftB <= rightA) {
                if (totalLen % 2 == 0) {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / (double) 2;
                } else {
                    return (double) Math.max(leftA, leftB);
                }
            } else if (leftA > rightB) {
                r = mA - 1;
            } else {
                l = mA + 1;
            }
        }
        return 0;
    }
}
