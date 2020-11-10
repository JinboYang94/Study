package ChallengeNov;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Queue;

public class MinimumHeightTrees {

  // leetcode 310
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> centroid = new ArrayList<>();
    if (n < 2) {
      centroid.add(0);
      return centroid;
    }
    // set up a HashSet shows the connection situation.
    List<Set<Integer>> link = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      link.add(new HashSet<>());
    }
    for (int[] edge : edges) {
      link.get(edge[0]).add(edge[1]);
      link.get(edge[1]).add(edge[0]);
    }
    // find all leaves(only one connection)
    Queue<Integer> leaves = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (link.get(i).size() == 1) {
        leaves.offer(i);
      }
    }
    // trim the leaves until find most inner nodes, only 1 or 2 possible roots
    while (!leaves.isEmpty()) {
      centroid = new ArrayList<>(); // create each iteration, only save the last to return
      // bfs
      int size = leaves.size();
      for (int i = 0; i < size; i++) {
        int curr = leaves.poll(); // current leaf
        centroid.add(curr); // add current leaf to temp ans
        Set<Integer> currAdj = link.get(curr);  // get current leaf's adjacent nodes
        for (int temp : currAdj) {
          link.get(temp).remove(curr);  // remove current leaf from this node
          if (link.get(temp).size() == 1) {
            leaves.offer(temp); // if this node becomes leaf, add it
          }
        }
      }
    }
    return centroid;
  }
}
