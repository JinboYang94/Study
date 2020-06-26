package LeetcodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * <p>
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * </p>
 */

class Leetcode210 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }
    // build DAG dependency
    for (int[] pre : prerequisites) {
      graph.get(pre[1]).add(pre[0]);
    }
    // visited mark, 0 is not yet visited
    Map<Integer, Integer> visited = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      visited.put(i, 0);
    }
    // dfs
    List<Integer> order = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, graph, visited, order)) {
        return new int[0];
      }
    }
    // not cycle, forward to answer
    int[] ans = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      ans[i] = order.get(numCourses - i - 1);
    }
    return ans;
  }

  private boolean dfs(int course, List<List<Integer>> graph, Map<Integer, Integer> visited,
      List<Integer> order) {
    int visitStatus = visited.get(course);
    // when 2, it means all nodes in the subtree has been dfs and all nodes are in order
    if (visitStatus == 2) {
      return true;
    }
    // detect cycle
    visited.put(course, 1);
    List<Integer> qualifiedCourses = graph.get(course);
    for (int i = 0; i < qualifiedCourses.size(); i++) {
      int qualifiedCourse = qualifiedCourses.get(i);
      if (visited.get(qualifiedCourse) == 1) {
        return false;
      }
      // if not visited, dfs children
      if (visited.get(qualifiedCourse) == 0) {
        if (!dfs(qualifiedCourse, graph, visited, order)) {
          return false;
        }
      }
    }
    visited.put(course, 2);
    // add this course into order
    order.add(course);
    return true;
  }
}
