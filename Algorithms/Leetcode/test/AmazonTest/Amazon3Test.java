package AmazonTest;

import OA.AmazonOA2.Amazon3;

/**
 * For OAProblems.AmazonOA2.Amazon3 testing.
 */

class Amazon3Test {

  public static void main(String[] args) {
    char[][] island1 = {{'S', 'O', 'O', 'S', 'S'},
                        {'D', 'O', 'D', 'O', 'D'},
                        {'O', 'O', 'O', 'O', 'X'},
                        {'X', 'D', 'D', 'O', 'O'},
                        {'X', 'D', 'D', 'D', 'O'}};

    char[][] island2 = {{'O', 'S', 'O', 'O', 'D'},
                        {'D', 'O', 'D', 'O', 'D'},
                        {'O', 'O', 'O', 'O', 'X'},
                        {'O', 'D', 'D', 'O', 'D'},
                        {'X', 'D', 'O', 'O', 'S'}};

    Amazon3 constructor = new Amazon3();
    System.out.println(constructor.findTreasure2(island1));
    System.out.println(constructor.findTreasure2(island2));
  }
}
