package LeetcodeProblems;

/**
 * // Definition for a LeetcodeProblems.Node.
 * class LeetcodeProblems.Node {
 *     public int val;
 *     public LeetcodeProblems.Node next;
 *     public LeetcodeProblems.Node random;
 *     public LeetcodeProblems.Node() {}
 *     public LeetcodeProblems.Node(int _val,LeetcodeProblems.Node _next,LeetcodeProblems.Node _random) {
 *         val = _val;
 *         next = _next;
 *         random = _random;
 *     }
 * };
 */

class LLNode {

  public int val;
  public LLNode next;
  public LLNode random;

  public LLNode() {}

  public LLNode(int _val,LLNode _next,LLNode _random) {
    val = _val;
    next = _next;
    random = _random;
  }
}
