class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] points = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            points[i][0] = position[i];
            points[i][1] = speed[i];
        }

        Arrays.sort(points, (a, b) -> b[0] - a[0]);
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            double time = (target - points[i][0]) /  (double) points[i][1];
            if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
