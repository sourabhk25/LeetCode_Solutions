class MyQueue {

    private Stack<Integer> s1, s2;
    
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.empty()) {
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        } else {
            return s2.pop();
        }        
    }
    
    public int peek() {
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        } else {
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return (s1.empty() && s2.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */