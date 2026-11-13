class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = Set.of("+", "-", "*", "/");

        for (String c : tokens) {
            if (operators.contains(c)) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                if (c.equals("+")) {
                    stack.push(a + b);
                } else if (c.equals("-")) {
                    stack.push(b - a);
                } else if (c.equals("*")) {
                    stack.push(a * b);
                } else {
                    stack.push(b / a);
                }
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}