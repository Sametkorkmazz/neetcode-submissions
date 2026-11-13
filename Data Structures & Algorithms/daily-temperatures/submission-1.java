class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[] {0};
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] result = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            int curr = temperatures[i];
            while (!stack.isEmpty() && curr > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}