class MinStack {
    Stack<Integer> stack;
    Stack<Integer> MinStack;

    public MinStack() {
        stack = new Stack<Integer>();
        MinStack = new Stack<Integer>();   
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            MinStack.push(val);
            return;
        }

        stack.push(val);

        if (val <= MinStack.peek())
            MinStack.push(val);
    }

    public void pop() {
        if (stack.peek().equals(MinStack.peek()))
            MinStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return MinStack.peek();
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