import java.util.List;

/**
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 *
 *     public Node() {}
 *
 *     public Node(int _val,List<Node> _neighbors) {
 *         val = _val;
 *         neighbors = _neighbors;
 *     }
 * };
 */

class GraphNode {

  public int val;
  public List<GraphNode> neighbors;

  public GraphNode() {}

  public GraphNode(int _val,List<GraphNode> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}
