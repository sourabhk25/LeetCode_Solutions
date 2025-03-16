class MinStack {

    Stack<Integer> stack, minStack;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.minStack.push(min);
    }
    
    public void push(int val) {
        if(min >= val) {    //push previous min first and update new min
            this.minStack.push(min);
            this.min = val; 
        }
        this.stack.push(val);   //push value
    }
    
    public void pop() {
        if(this.stack.pop() == this.min) {  //if true deleting current minimum else element is poped anyways
            this.min = this.minStack.pop(); //update min by using previous min
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */