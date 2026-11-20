class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0;
        for (int i = 0; i < res.length; i++) {
            if (i2 >= nums2.length || (i1 < nums1.length && nums1[i1] < nums2[i2])) {
                res[i] = nums1[i1];
                i1++;
            } else {
                res[i] = nums2[i2];
                i2++;
            }
        }

        int l = 0, r = res.length - 1;
        if (res.length > 1 && res.length % 2 == 0) {
            int m = res[(l + r) / 2];
            return ((double) m + res[(l + r) / 2 + 1]) / 2;

        } else if (res.length > 0) {
            int m = res[(l + r) / 2];
            return (double) m;
        }
        return 0;
    }
}