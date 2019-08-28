import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Improvement, copy while BFS
 */

class Leetcode133b {

  public GraphNode cloneGraph(GraphNode node) {
    if (node == null) {
      return null;
    }
    Queue<GraphNode> queue = new LinkedList<>();
    Map<GraphNode, GraphNode> copy = new HashMap<>();
    queue.offer(node);
    copy.put(node, new GraphNode(node.val, new ArrayList<>()));
    // bfs
    while (!queue.isEmpty()) {
      GraphNode curr = queue.poll();
      for (GraphNode neighbour : curr.neighbors) {
        // neighbour not exists in copy, then add it
        if (!copy.containsKey(neighbour)) {
          copy.put(neighbour, new GraphNode(neighbour.val, new ArrayList<>()));
          queue.offer(neighbour);
        }
        // after exists, then copy neighbour
        copy.get(curr).neighbors.add(copy.get(neighbour));
      }
    }
    return copy.get(node);
  }
}
