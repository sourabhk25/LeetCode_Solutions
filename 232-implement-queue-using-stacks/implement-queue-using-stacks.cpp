#include<bits/stdc++.h>
class MyQueue {
public:
    stack<int> s1,s2;
    int size;
    MyQueue() {
        size = 0;
    }
    
    void push(int x) {
        s1.push(x);
    }
    
    int pop() {
        if(s2.empty()){
            while(!s1.empty()){
                int topE = s1.top();
                s1.pop();
                s2.push(topE);
            }
            int topS2 = s2.top();
            s2.pop();
            return topS2;
        } else{
            int topS2 = s2.top();
            s2.pop();
            return topS2;
        }
    }
    
    int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                int topE = s1.top();
                s1.pop();
                s2.push(topE);
            }
            int topS2 = s2.top();
            return topS2;
        } else{
            int topS2 = s2.top();
            return topS2;
        }
    }
    
    bool empty() {
        return (s1.empty() && s2.empty());
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */