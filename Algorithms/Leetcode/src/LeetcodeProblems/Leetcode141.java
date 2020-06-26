package LeetcodeProblems;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list
 * where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * <p>
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * 3---->2---->0---->4--
 *       ^             |
 *       --------------|
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 *
 *
 * Follow up:
 *
 * Can you solve it using O(1) (i.e. constant) memory?
 * </p>
 */

class Leetcode141 {

  public boolean hasCycle(ListNode head) {
    ListNode curr = head;
    Set<ListNode> pool = new HashSet<>();
    while (curr != null) {
      if (pool.contains(curr)) {
        return true;
      } else {
        pool.add(curr);
      }
      curr = curr.next;
    }
    return false;
  }
}
