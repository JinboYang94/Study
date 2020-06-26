package AmazonTest;

import OA.AmazonOA2.Amazon10;
import java.util.Arrays;

/**
 * For OAProblems.AmazonOA2.Amazon10 testing.
 */

class Amazon10Test {

  public static void main(String[] args) {
    int n1 = 5;
    int[][] edges1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
    int[][] brokenEdges1 = {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}};

    int n2 = 6;
    int[][] edges2 = {{1, 2}, {2, 3}, {4, 5}, {3, 5}, {1, 6}, {2, 4}};
    int[][] brokenEdges2 = {{1, 6, 410}, {2, 4, 800}};

    int n3 = 6;
    int[][] edges3 = {{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 5}, {2, 4}, {3, 4}};
    int[][] brokenEdges3 = {{1, 5, 110}, {2, 4, 84}, {3, 4, 79}};

    Amazon10 construct = new Amazon10();
    System.out.println(construct.repairMST(n1, edges1, brokenEdges1));
    System.out.println(Arrays.toString(construct.parent));
    System.out.println("-------------------------------------------");
    System.out.println(construct.repairMST(n2, edges2, brokenEdges2));
    System.out.println(Arrays.toString(construct.parent));
    System.out.println("-------------------------------------------");
    System.out.println(construct.repairMST(n3, edges3, brokenEdges3));
    System.out.println(Arrays.toString(construct.parent));
  }
}
