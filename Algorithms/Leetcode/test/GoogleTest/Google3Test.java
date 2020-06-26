package GoogleTest;

import OA.GoogleOA.Google3;

class Google3Test {

  public static void main(String[] args) {
    int[] plants1 = {2, 4, 5, 1, 2};
    int cap1 = 6;

    Google3 constructor = new Google3();
    System.out.println(constructor.minStepsWaterPlants(plants1, cap1));
  }
}
