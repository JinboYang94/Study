package AmazonTest;

import OA.AmazonOA2.Amazon14;

/**
 * For OAProblems.AmazonOA2.Amazon14 testing.
 */

class Amazon14Test {

  public static void main(String[] args) {
    int[] foreground1 = {1, 7, 2, 4, 5, 6};
    int[] background1 = {3, 1, 2};
    int k1 = 6;

    int[] foreground2 = {1, 7, 2, 4, 5, 6};
    int[] background2 = {3, 1, 2};
    int k2 = 10;

    Amazon14 constructor = new Amazon14();
    System.out.println(constructor.assignTasks(foreground1, background1, k1));
    System.out.println(constructor.assignTasks(foreground2, background2, k2));
  }
}
