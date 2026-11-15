class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int middle = l + ((r - l) / 2);
            int num = nums[middle];
            if (target > num) {
                l = middle + 1;
            } else if (target < num) {
                r = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}