class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<List<Integer>> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().get(1) > heights[i]) {
                List<Integer> height = stack.pop();
                max = Math.max(max, (i - height.get(0)) * height.get(1));
                start = height.get(0);
            }
            stack.push(List.of(start, heights[i]));
        }
        while (!stack.isEmpty()) {
            List<Integer> height = stack.pop();
            max = Math.max(max, (heights.length - height.get(0)) * height.get(1));
        } 
        return max;
    }
}
