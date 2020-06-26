package OA.AmazonOA2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * There's an undirected connected graph with n nodes labeled 1..n. But some of the edges has been
 * broken disconnecting the graph.
 * Find the minimum cost to repair the edges so that all the nodes are once again accessible
 * from each other.
 * Input:
 * n, an int representing the total number of nodes.
 * edges, a list of integer pair representing the nodes connected by an edge.
 * edgesToRepair, a list where each element is a triplet representing the pair of nodes between
 *               which an edge is currently broken and the cost of repairing that edge, respectively
 *            (e.g. [1, 2, 12] means to repair an edge between nodes 1 and 2, the cost would be 12).
 *
 * <p>
 * Example 1:
 *
 * Input: n = 5,
 * edges = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]],
 * edgesToRepair = [[1, 2, 12], [3, 4, 30], [1, 5, 8]]
 * Output: 20
 * Explanation:
 * There are 3 connected components due to broken edges: [1], [2, 3] and [4, 5].
 * We can connect these components into a single component by repairing the edges
 * between nodes 1 and 2, and nodes 1 and 5 at a minimum cost 12 + 8 = 20.
 * Example 2:
 *
 * Input: n = 6,
 * edges = [[1, 2], [2, 3], [4, 5], [3, 5], [1, 6], [2, 4]],
 * edgesToRepair = [[1, 6, 410], [2, 4, 800]]
 * Output: 410
 * Example 3:
 *
 * Input: n = 6,
 * edges = [[1, 2], [2, 3], [4, 5], [5, 6], [1, 5], [2, 4], [3, 4]],
 * edgesToRepair = [[1, 5, 110], [2, 4, 84], [3, 4, 79]]
 * Output: 79
 * </p>
 */

public class Amazon10 {

  public int[] parent;
  public int count;

  public int repairMST(int n, int[][] edges, int[][] broken) {
    parent = new int[n + 1];
    count = n;
    for (int i = 1; i < parent.length; i++) {
      parent[i] = i;
    }
    Set<String> brokenEdges = new HashSet<>();
    for (int[] edge : broken) {
      brokenEdges.add(Arrays.toString(Arrays.copyOfRange(edge, 0, 2)));
    }
    for (int[] edge : edges) {
      if (!brokenEdges.contains(Arrays.toString(edge))) {
        union(edge[0], edge[1]);
      }
    }
    Arrays.sort(broken, (a, b) -> (a[2] - b[2]));
    int ans = 0;
    for (int i = 0; i < broken.length; i++) {
      if (!isConnected(broken[i][0], broken[i][1])) {
        union(broken[i][0], broken[i][1]);
        ans += broken[i][2];
        if (count == 1) {
          return ans;
        }
      }
    }
    return -1;
  }

  // find root of p
  private int find(int p) {
    while (p != parent[p]) {
      p = parent[p];
      parent[p] = parent[parent[p]];
    }
    return p;
  }

  // union two nodes
  private void union(int p1, int p2) {
    if (find(p1) == find(p2)) {
      return;
    }
    int root = find(p1);
    int root2 = find(p2);
    parent[root2] = root;
    count--;
    // change all children of p2's root directed to root
    for (int i = 0; i < parent.length; i++) {
      if (root2 == parent[i]) {
        parent[i] = root;
      }
    }
  }

  private boolean isConnected(int p1, int p2) {
    return find(p1) == find(p2);
  }
}
