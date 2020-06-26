package AmazonTest;

import OA.AmazonOA2.Amazon2;

/**
 * For OAProblems.AmazonOA2.Amazon2 testing.
 */

class Amazon2Test {

  public static void main(String[] args) {
    char[][] island1 = {{'O', 'O', 'O', 'O'},
                        {'D', 'O', 'D', 'O'},
                        {'O', 'O', 'O', 'O'},
                        {'X', 'D', 'D', 'O'}};

    char[][] island2 = {{'O', 'O', 'O', 'O'},
                        {'O', 'D', 'D', 'O'},
                        {'D', 'O', 'X', 'O'},
                        {'O', 'O', 'O', 'O'}};

    Amazon2 constructor = new Amazon2();
    System.out.println(constructor.findTreasure(island1));
    System.out.println(constructor.findTreasure(island2));
  }
}
