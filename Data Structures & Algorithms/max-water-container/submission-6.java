class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int axis = r - l;
            int area = axis * Math.min(height[l], height[r]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
