class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int l = 0, r = n;
        int last = nums[n];
        while (l < r) {
            int m = (l + r) >> 1;
            if (nums[m] > last)
                l = m + 1;
            else
                r = m ;
        }
        return nums[l];
    }
}
