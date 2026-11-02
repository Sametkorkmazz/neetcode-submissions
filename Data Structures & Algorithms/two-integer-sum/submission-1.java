class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i= 0; i< nums.length; i++){
            Integer sub = map.get(target - nums[i]);
            if(sub != null) {
                return new int[]{ sub, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
