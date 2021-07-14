/*
 * @lc app=leetcode id=232 lang=cpp
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> st1, st2;
    
    /** Push element x to the back of queue. */
    void push(int x) {
        while (!st1.empty()) {
            st2.push(st1.top());
            st1.pop();
        }
        st2.push(x);
        while (!st2.empty()) {
            st1.push(st2.top());
            st2.pop();
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int top = st1.top();
        st1.pop();
        return top;
    }
    
    /** Get the front element. */
    int peek() {
        return st1.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return st1.empty();
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
// @lc code=end

