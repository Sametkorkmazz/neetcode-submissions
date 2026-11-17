class Solution {
    public int findMin(int[] nums) {
        int result = nums[0];
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] < nums[r]) {
                result = Math.min(result, nums[l]);
            }
            int m = (l + r) / 2;
            result =Math.min(result, nums[m]);
            if (nums[m] >= nums[l]) {
                l = m + 1 ;
            } else {
                r = m - 1;
            }
        }
        return result;
    }
}
