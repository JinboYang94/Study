package GoogleTest;

import OA.GoogleOA.Google1;

class Google1Test {

  public static void main(String[] args) {
    int[] array1 = {2, 9, 12, 13, 4, 7, 6, 5, 10};
    int[] array2 = {5, 2, 4, 3, 1, 6};
    int[] array3 = {1, 1, 1};

    Google1 constructor = new Google1();
    System.out.println(constructor.minDesSubseq(array1));
    System.out.println(constructor.minDesSubseq(array2));
    System.out.println(constructor.minDesSubseq(array3));
    System.out.println("------------------------------");
    System.out.println(constructor.minDesSubseq2(array1));
    System.out.println(constructor.minDesSubseq2(array2));
    System.out.println(constructor.minDesSubseq2(array3));
  }
}
