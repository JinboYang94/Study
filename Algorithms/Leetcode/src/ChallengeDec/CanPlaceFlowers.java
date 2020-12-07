package ChallengeDec;

public class CanPlaceFlowers {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    if (flowerbed.length == 1) {
      count = flowerbed[0] == 0 ? 1 : 0;
      return count >= n;
    }
    for (int i = 0; i < flowerbed.length; i++) {
      if ((i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0)
          || (i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0)
          || (i != 0 && i != flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0
          && flowerbed[i + 1] == 0)) {
        flowerbed[i] = 1;
        count++;
      }
    }
    return count >= n;
  }
}
