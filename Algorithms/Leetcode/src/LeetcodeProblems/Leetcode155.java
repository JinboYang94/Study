package LeetcodeProblems;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *
 * <p>
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * </p>
 */

class Leetcode155 {

  private Stack<Integer> stack;
  private Stack<Integer> min;

  public Leetcode155() {
    stack = new Stack<>();
    min = new Stack<>();
  }

  public void push(int x) {
    if (min.isEmpty() || min.peek() >= x) {
      min.push(x);
    }
    stack.push(x);
  }

  public void pop() {
    if (!min.isEmpty() && stack.peek().equals(min.peek())) {
      min.pop();
    }
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min.peek();
  }
}
