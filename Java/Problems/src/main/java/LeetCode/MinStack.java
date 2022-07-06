package LeetCode;


import java.util.Stack;

/***
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {
    private Stack<Integer> stack;
    private  Stack<Integer> minStack;


    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        //put in stack
        stack.push(val);

        if(minStack.isEmpty() && val <= minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        if(minStack.peek().equals(stack.peek())){
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 *
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
