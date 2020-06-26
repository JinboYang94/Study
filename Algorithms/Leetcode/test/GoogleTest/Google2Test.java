package GoogleTest;

import OA.GoogleOA.Google2;

class Google2Test {

  public static void main(String[] args) {
    int[] coupons1 = {5, 3, 4, 2, 3, 4, 5, 7};
    int[] coupons2 = {3, 6, 1, 9};

    Google2 constructor = new Google2();
    System.out.println(constructor.minPickUpCoupons(coupons1));
    System.out.println(constructor.minPickUpCoupons(coupons2));
  }
}
