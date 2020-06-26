package AmazonTest;

import OA.AmazonOA2.Amazon15;

/**
 * For OAProblems.AmazonOA2.Amazon15 testing.
 */

class Amazon15Test {

  public static void main(String[] args) {
    int[] ropes1 = {8, 4, 6, 12};
    int[] ropes2 = {20, 4, 8, 2};
    int[] ropes3 = {1, 2, 5, 10, 35, 89};
    int[] ropes4 = {2, 2, 3, 3};

    Amazon15 constructor = new Amazon15();
    System.out.println(constructor.connectRopes(ropes1));
    System.out.println(constructor.connectRopes(ropes2));
    System.out.println(constructor.connectRopes(ropes3));
    System.out.println(constructor.connectRopes(ropes4));
  }
}
