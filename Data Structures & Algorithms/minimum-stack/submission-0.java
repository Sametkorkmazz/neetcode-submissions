class MinStack {

    Stack<Integer> elements;

    Stack<Integer> minimum;

    public MinStack() {
        elements = new Stack<>();
        minimum = new Stack<>();
    }

    public void push(int value) {
        elements.push(value);
        if (!minimum.isEmpty()) {
            minimum.push(Math.min(value, minimum.peek()));
        } else {
            minimum.push(value);
        }
    }

    public void pop() {
        elements.pop();
        minimum.pop();
    }

    public int top() {
        return elements.peek();
    }

    public int getMin() {
        return minimum.peek();
    }
}
