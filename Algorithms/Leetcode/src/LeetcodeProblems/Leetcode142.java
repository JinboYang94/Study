package LeetcodeProblems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list
 * where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Note: Do not modify the linked list.
 *
 * <p>
 *
 * </p>
 */

class Leetcode142 {

  public ListNode detectCycle(ListNode head) {
    Set<ListNode> pool = new HashSet<>();
    while (head != null) {
      if (pool.contains(head)) {
        return head;
      } else {
        pool.add(head);
      }
      head = head.next;
    }
    return null;
  }
}
