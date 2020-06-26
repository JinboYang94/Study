package LeetcodeProblems;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:        a1 --> a2 --
 *                       --> c1 --> c2 --> c3
 * B: b1 --> b2 --> b3 --
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * <p>
 * Example 1:
 * A:       4 --> 1 --
 *                    --> 8 --> 4 --> 5
 * B: 5 --> 0 --> 1 --
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8
 * (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B,
 * it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A;
 * There are 3 nodes before the intersected node in B.
 * </p>
 */

class Leetcode160 {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode p1 = headA;
    ListNode p2 = headB;
    while (p1 != p2) {
      p1 = p1 == null ? headB : p1.next;
      p2 = p2 == null ? headA : p2.next;
    }
    return p1;
  }
}
