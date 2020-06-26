package AmazonTest;

import OA.AmazonOA2.Amazon9;
import java.util.Arrays;

/**
 * For OAProblems.AmazonOA2.Amazon9 testing.
 */

class Amazon9Test {

  public static void main(String[] args) {
    int n1 = 6;
    int[][] edges1 = {{1, 4}, {2, 3}, {4, 5}};
    int[][] newEdges1 = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};

    int n2 = 6;
    int[][] edges2 = {{1, 4}, {2, 3}, {4, 5}};
    int[][] newEdges2 = {{1, 2, 5}, {1, 3, 3}, {1, 6, 2}, {5, 6, 5}};

    Amazon9 constructor = new Amazon9();
    System.out.println(constructor.minCostSpanningTree(n1, edges1, newEdges1));
    System.out.println(Arrays.toString(constructor.parent));
    System.out.println("---------------------------------------");
    System.out.println(constructor.minCostSpanningTree(n2, edges2, newEdges2));
    System.out.println(Arrays.toString(constructor.parent));
  }
}
