package LeetcodeProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A more concise one queue solution.
 */

public class Leetcode225b {

  private Queue<Integer> queue = new LinkedList<>();

  /** Initialize your data structure here */
  public Leetcode225b() {}

  /** Push element x onto stack */
  public void push(int x) {
    queue.offer(x);
    // reverse the queue for each time push new element.
    for (int i = 1; i < queue.size(); i++) {
      queue.offer(queue.remove());
    }
  }

  /** Remove the element on top of the stack and returns that element */
  public int pop() {
    return queue.poll();
  }

  /** Get the top element */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty */
  public boolean empty() {
    return queue.isEmpty();
  }
}
