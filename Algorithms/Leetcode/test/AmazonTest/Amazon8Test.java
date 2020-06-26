package AmazonTest;

import OA.AmazonOA2.Amazon8;

/**
 * For OAProblems.AmazonOA2.Amazon8 testing.
 */

class Amazon8Test {

  public static void main(String[] args) {
    int[] dices1 = {1, 2, 3};
    int[] dices2 = {1, 1, 6};
    int[] dices3 = {1, 6, 2, 3};

    Amazon8 constructor = new Amazon8();
    System.out.println(constructor.minMove(dices1));
    System.out.println(constructor.minMove(dices2));
    System.out.println(constructor.minMove(dices3));
  }
}
