package LeetcodeProblems;

import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 */

public class Leetcode382 {

  // follow-up solution: In order to do random sampling over a population of unknown size
  // with constant space, the answer is reservoir sampling.
  private ListNode h;
  private Random rand;
  public Leetcode382(ListNode head) {
    this.h = head;
    this.rand = new Random();
  }

  public int getRandom() {
    ListNode curr = this.h;
    // init with 0, cant be 1
    int count = 0;
    int ret = 0;
    while (curr != null) {
      // if [0, count] random to count, then choose into reservoir
      if (rand.nextInt(count + 1) == count) {
        ret = curr.val;
      }
      // next node
      count++;
      curr = curr.next;
    }
    return ret;
  }
}
