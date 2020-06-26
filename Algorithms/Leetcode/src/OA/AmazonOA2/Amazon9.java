package OA.AmazonOA2;

import java.util.Arrays;

/**
 * Given an undirected graph with n nodes labeled 1..n. Some of the nodes are already connected.
 * The i-th edge connects nodes edges[i][0] and edges[i][1] together.
 * Your task is to augment this set of edges with additional edges to connect all the nodes.
 * Find the minimum cost to add new edges between the nodes such that all the nodes are
 * accessible from each other.
 * Input:
 * n, an int representing the total number of nodes.
 * edges, a list of integer pair representing the nodes already connected by an edge.
 * newEdges, a list where each element is a triplet representing the pair of nodes between which
 * an edge can be added and the cost of addition, respectively
 * (e.g. [1, 2, 5] means to add an edge between node 1 and 2, the cost would be 5).
 *
 * <p>
 * Example:
 * Input:
 * n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
 * Output: 7
 * Explanation:
 * There are 3 connected components [1, 4, 5], [2, 3] and [6].
 * We can connect these components into a single component by connecting node 1 to node 2 and
 * node 1 to node 6 at a minimum cost of 5 + 2 = 7.
 * </p>
 */

public class Amazon9 {

  public int[] parent;
  public int count;

  public int minCostSpanningTree(int n, int[][] edges, int[][] newEdges) {
    // nodes are starting from 1, so n + 1
    parent = new int[n + 1];
    count = n;
    // initialize UF
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }
    for (int[] edge : edges) {
      union(edge[0], edge[1]);
    }
    Arrays.sort(newEdges, (a, b) -> (a[2] - b[2]));
    int ans = 0;
    for (int i = 0; i < newEdges.length; i++) {
      if (!isConnected(newEdges[i][0], newEdges[i][1])) {
        union(newEdges[i][0], newEdges[i][1]);
        ans += newEdges[i][2];
        if (count == 1) {
          return ans;
        }
      }
    }
    return -1;
  }

  // find root of Node p
  private int find(int p) {
    while (p != parent[p]) {
      p = parent[p];
      parent[p] = parent[parent[p]];
    }
    return p;
  }

  // union two node into one graph
  private void union(int p1, int p2) {
    if (find(p1) == find(p2)) {
      return;
    }
    int root = find(p1);
    int root2 = find(p2);
    count--;
    parent[root2] = root;
    // change all root2's children's root to root
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
