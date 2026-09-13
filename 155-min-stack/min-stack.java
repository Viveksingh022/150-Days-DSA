class Node {
    int val;
    int min;

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Node(val, val));
            return;
        }

        int mintop = stack.peek().min;
        stack.push(new Node(val, Math.min(val, mintop)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */