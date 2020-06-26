package LeetcodeProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back,
 * peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively.
 * You may simulate a queue by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a queue.
 * You may assume that all operations are valid
 * (for example, no pop or top operations will be called on an empty stack).
 *
 * <p>
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * </p>
 */

public class Leetcode225 {

  private Queue<Integer> queue1 = new LinkedList<>();
  private Queue<Integer> queue2 = new LinkedList<>();
  private int top;

  public Leetcode225() {}

  /** Push element x onto stack */
  public void push(int x) {
    queue1.offer(x);
    top = x;
  }

  /** Remove the element on top of the stack and returns that element */
  public int pop() {
    // store all queue1's elements into queue2, besides the one to be popped.
    while (queue1.size() > 1) {
      top = queue1.remove();
      queue2.add(top);
    }
    int last = queue1.remove();
    // temp is empty
    Queue<Integer> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
    return last;
  }

  /** Get the top element */
  public int top() {
    return top;
  }

  /** Returns whether the stack is empty */
  public boolean empty() {
    return queue1.isEmpty();
  }
}
