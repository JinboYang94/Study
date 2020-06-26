package GoogleTest;

import OA.GoogleOA.Google5;

/**
 * For Google5 testing.
 */

class Google5Test {

  public static void main(String[] args) {
    int[] A1 = {2, 1, 2, 4, 2, 2};
    int[] B1 = {5, 2, 6, 2, 3, 2};

    int[] A2 = {3, 5, 1, 2, 3};
    int[] B2 = {3, 6, 3, 3, 4};

    Google5 constructor = new Google5();
    System.out.println(constructor.minDominoRotations(A1, B1));
    System.out.println(constructor.minDominoRotations(A2, B2));
  }
}
