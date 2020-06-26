package LeetcodeProblems;

/**
 * // Definition for a LeetcodeProblems.Node.
 * class LeetcodeProblems.Node {
 *     public int val;
 *     public LeetcodeProblems.Node left;
 *     public LeetcodeProblems.Node right;
 *     public LeetcodeProblems.Node next;
 *     public LeetcodeProblems.Node() {}
 *     public LeetcodeProblems.Node(int _val,LeetcodeProblems.Node _left,LeetcodeProblems.Node _right,LeetcodeProblems.Node _next) {
 *         val = _val;
 *         left = _left;
 *         right = _right;
 *         next = _next;
 *     }
 * };
 */

class Node {

  public int val;
  public Node left;
  public Node right;
  public Node next;
  public Node() {}

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}
