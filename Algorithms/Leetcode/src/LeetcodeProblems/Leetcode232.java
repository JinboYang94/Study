package LeetcodeProblems;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 *
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top,
 * peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively.
 * You may simulate a stack using a list or deque (double-ended queue) as long as
 * you use only a stack's standard operations.
 *
 * Follow-up: Can you implement the queue such that each operation is
 * amortized O(1) time complexity? In other words, performing n operations will take
 * overall O(n) time even if one of those operations may take longer.
 */

public class Leetcode232 {

  private Stack<Integer> s1 = null; // input stack
  private Stack<Integer> s2 = null; // output stack

  public Leetcode232() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  public void push(int x) {
    s1.push(x);
  }

  public int pop() {
    peek();
    return s2.pop();
  }

  public int peek() {
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
    }
    return s2.peek();
  }

  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }
}
