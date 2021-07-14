/*
 * @lc app=leetcode id=155 lang=cpp
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
public:
    /** initialize your data structure here. */
    private:
        vector<int> st;
        int min;
    public:
        MinStack() {
            min = INT_MAX;
        }
        
        void push(int val) {
            if (min >= val) {
                st.push_back(min);
                min = val;
            }
            st.push_back(val);
        }
        
        void pop() {
            if (min == st.back()) {
                st.pop_back();
                min = st.back();
                st.pop_back();
            } else {
                st.pop_back();
            }
        }
        
        int top() {
            return st.back();
        }
        
        int getMin() {
            return min;
        }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
// @lc code=end

