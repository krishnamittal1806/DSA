class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int value) {

        stack.push(value);

        if(minstack.isEmpty() || value <= minstack.peek()){
            minstack.push(value);
        }
        
    }
    
    public void pop() {
       if(minstack.peek().equals(stack.peek())) {
        minstack.pop();
       }
       stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
        
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