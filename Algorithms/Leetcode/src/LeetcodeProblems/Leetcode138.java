package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 * Note:
 * You must return the copy of the given head as a reference to the cloned list.
 *
 * <p>
 * Example 1:
 *    1                  2
 *  next  -----------> next -------> null
 *  random ----------> random ----
 *                       ^       |
 *                       |-------|
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 * </p>
 */

class Leetcode138 {

  public LLNode copyRandomList(LLNode head) {
    Map<LLNode, LLNode> map = new HashMap<>();
    LLNode curr = head;
    // add all nodes to HashMap
    while (curr != null) {
      LLNode newNode = new LLNode(curr.val, null, null);
      map.put(curr, newNode);
      curr = curr.next;
    }
    // assign next and random
    curr = head;
    while (curr != null) {
      map.get(curr).next = map.get(curr.next);
      map.get(curr).random = map.get(curr.random);
      curr = curr.next;
    }

    return map.get(head);
  }
}
