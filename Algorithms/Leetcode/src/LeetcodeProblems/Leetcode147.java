package LeetcodeProblems;

/**
 * Sort a linked list using insertion sort.
 * A graphical example of insertion sort.
 * The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place
 * into the sorted list
 * Algorithm of Insertion Sort:
 * Insertion sort iterates, consuming one input element each repetition,
 * and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * <p>
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * </p>
 */

class Leetcode147 {

  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode curr = head; // loop index
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    while (curr.next != null) {
      // find descending, need to insert
      if (curr.val > curr.next.val) {
        ListNode temp = curr.next;  // node needed to be inserted
        // start from head to find where to insert
        ListNode newHead = dummy;
        while (newHead.next.val < temp.val) {
          newHead = newHead.next;
        }
        // isolate the temp
        curr.next = temp.next;
        // insert
        temp.next = newHead.next;
        newHead.next = temp;
      } else {
        curr = curr.next;
      }
    }
    return dummy.next;
  }
}
