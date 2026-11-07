class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int a = 0;
        while (a < nums.length - 2) {
            int l = a + 1;
            int r = nums.length - 1;
            int total = nums[a] * -1;
            while (l < r) {
                int curr = nums[l] + nums[r];
                if (curr < total) {
                    l++;
                } else if (curr > total) {
                    r--;
                } else {
                    result.add(List.of(nums[a], nums[l], nums[r]));
                    l++;
                    r--;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                    while (nums[r] == nums[r + 1] && l < r) {
                        r--;
                    }
                }
            }
            a++;
            while (nums[a] == nums[a - 1] && a < nums.length - 2) {
                a++;
            }
        }
        return result;
    }
}
