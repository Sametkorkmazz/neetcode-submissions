class Solution {
    public int trap(int[] height) {
        int[] prefix = new int[height.length];
        int curr = 0;
        for (int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(height[i - 1], curr);
            curr = prefix[i];
        }
         curr = 0;
        int[] suffix = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(height[i + 1], curr);
curr = suffix[i];        }

        for (int i = 0; i < height.length; i++) {
            height[i] = Math.max(0, Math.min(prefix[i], suffix[i]) - height[i]);
        }
        int total = 0;
        for (int num : height) {
            total += num;
        }
        return total;
    }
}
