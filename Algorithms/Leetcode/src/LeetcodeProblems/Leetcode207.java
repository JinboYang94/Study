package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first
 * take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs,
 * is it possible for you to finish all courses?
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * <p>
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * </p>
 */

class Leetcode207 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }
    // create DAG dependency
    for (int i = 0; i < prerequisites.length; i++) {
      graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }
    // visit
    int[] visited = new int[numCourses];
    // dfs
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, graph, visited)) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(int course, List<List<Integer>> graph, int[] visited) {
    // mark it as being visited
    visited[course] = 1;
    // get all qualified courses after study this course as its children
    List<Integer> qualifiedCourses = graph.get(course);
    // for each qualified course
    for (int i = 0; i < qualifiedCourses.size(); i++) {
      int qualifiedCourse = qualifiedCourses.get(i);
      // this course has been visited while visiting its children, so acyclic, thus false
      if (visited[qualifiedCourse] == 1) {
        return false;
      }
      //if not visited, dfs its children
      if (visited[qualifiedCourse] == 0) {
        if (!dfs(qualifiedCourse, graph, visited)) {
          return false;
        }
      }
    }
    // mark it as visited done
    visited[course] = 2;
    return true;
  }
}
