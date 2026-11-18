class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            if (nums[l] < nums[r]) {
                if (nums[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] >= nums[l]) {
                    if (nums[m] > target) {
                        if (nums[l] <= target) {
                            r = m - 1;
                        } else {
                            l = m + 1;
                        }
                    } else {
                        l = m + 1;
                    }
                } else {
                    if (nums[m] < target) {
                        if (nums[r] >= target) {
                            l = m + 1;
                        } else {
                            r = m - 1;
                        }
                    } else {
                        r = m - 1;
                    }
                }
            }
        }
        return -1;
    }
}
