package LeetcodeProblems;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * <p>
 * Example:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 * </p>
 */

class Leetcode82 {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0); // track real node in final answer
    ListNode dummy2 = new ListNode(0);  // use to return
    ListNode curr = head; // track current node
    dummy.next = head;
    dummy2.next = dummy;

    while (curr != null) {  // check all nodes
      if (curr.next != null && curr.val == curr.next.val) {
        while (curr.next != null && curr.val == curr.next.val) {
          curr = curr.next; // skip all duplicates
        }
        dummy.next = curr.next; // link dummy to next qualified node
      } else {
        dummy = curr; // no duplicates condition, just add curr as qualified node (***)
      }
      curr = curr.next; // keep moving to check next node
    }
    return dummy2.next.next;
  }
}
