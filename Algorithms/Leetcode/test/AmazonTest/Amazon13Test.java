package AmazonTest;

import OA.AmazonOA2.Amazon13;

/**
 * For OAProblems.AmazonOA2.Amazon13 testing.
 */

class Amazon13Test {

  public static void main(String[] args) {
    int row1 = 3;
    int col1 = 3;
    int[][] grid1 = {{1, 0, 0},
                     {1, 0, 0},
                     {1, 9, 1}};

    Amazon13 constructor = new Amazon13();
    System.out.println(constructor.moveObstacle(row1, col1, grid1));
  }
}
