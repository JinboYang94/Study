package ChallengeDec;

import LeetcodeProblems.ListNode;
import java.util.ArrayList;

public class LinkedListRandomNode {

  ArrayList<Integer> pool = new ArrayList<>();

  public LinkedListRandomNode(ListNode head) {
    while (head != null) {
      pool.add(head.val);
      head = head.next;
    }
  }

  public int getRandom() {
    int pick = (int) (Math.random() * pool.size());
    return pool.get(pick);
  }

  // follow up solution: go to leetcode 382
}
