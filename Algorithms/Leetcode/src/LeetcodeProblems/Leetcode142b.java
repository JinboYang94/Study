package LeetcodeProblems;

/**
 * O(1) solution.
 * Explanation:
 * When slow meets fast, from meeting point to loop ending point: x1
 * from loop starting point to meeting point: x2
 * from head to loop starting/ending point: x3
 * 1------->2------->3----->4
 *   x3     ↑      x2       |
 *          |---------------|
 *                 x1
 * Relationship: when meets, fast moves x3 + x2 + x1 + x2, slow moves x3 + x2
 *               x3 + x2 + x1 + x2 = 2 * (x3 + x2)
 *               so we get x1 = x3
 * Here set slow to head, equally move slow and fast, when they meet that's the loop point.
 */

class Leetcode142b {

  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      // has cycle
      if (slow == fast) {
        slow = head;
        // using this method to get ans
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }
}
