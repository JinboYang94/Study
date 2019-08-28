import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.List;
import java.util.Set;

/**
 * Given a reference of a node in a connected undirected graph,
 * return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * <p>
 * Example:
 *   1------2
 *   |      |
 *   4------3
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},
 * {"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":
 * [{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},
 * {"$ref":"4"}],"val":1}
 *
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 * </p>
 */

class Leetcode133 {

  public GraphNode cloneGraph(GraphNode node) {
    if (node == null) {
      return null;
    }
    // bfs get all nodes
    List<GraphNode> allNodes = getNodes(node);
    // copy nodes, copy val
    Map<GraphNode, GraphNode> copy = new HashMap<>();
    for (GraphNode n : allNodes) {
      copy.put(n, new GraphNode(n.val, new ArrayList<>()));
    }
    // copy edges
    for (GraphNode n : allNodes) {
      GraphNode newNode = copy.get(n);
      for (GraphNode nei : n.neighbors) {
        GraphNode newNei = copy.get(nei);
        newNode.neighbors.add(newNei);
      }
    }
    return copy.get(node);
  }

  private List<GraphNode> getNodes(GraphNode node) {
    Queue<GraphNode> queue = new LinkedList<>();
    Set<GraphNode> nextNodes = new HashSet<>();
    queue.offer(node);
    nextNodes.add(node);

    while (!queue.isEmpty()) {
      GraphNode curr = queue.poll();
      for (GraphNode neighbour : curr.neighbors) {
        if (!nextNodes.contains(neighbour)) {
          nextNodes.add(neighbour);
          queue.offer(neighbour);
        }
      }
    }
    List<GraphNode> ret = new ArrayList<>(nextNodes);
    return ret;
  }
}
