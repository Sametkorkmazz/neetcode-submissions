class Solution {
    public boolean isValid(String s) {
        CustomStack<Character> stack = new CustomStack<>(s.length());
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                Character opening = stack.pop();
                if (opening == null) {
                    return false;
                }
                if (c == ')' && opening != '(') {
                    return false;
                } else if (c == ']' && opening != '[') {
                    return false;
                } else if (c == '}' && opening != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    class CustomStack<T> {
        int head = 0;
        T[] elements;

        public CustomStack() {
            this.elements = (T[]) new Object[5];

        }

        public CustomStack(int size) {
            this.elements = (T[]) new Object[size];
        }

        public boolean push(T element) {
            if (isFull()) {
                return false;
            }
            elements[head++] = element;
            return true;
        }

        public T pop() {
            if (isEmpty()) {
                return null;
            }
            T element = elements[head - 1];
            elements[head--] = null;
            return element;
        }

        public boolean isFull() {
            return head == elements.length;
        }

        public boolean isEmpty() {
            return head == 0;
        }

    }
}