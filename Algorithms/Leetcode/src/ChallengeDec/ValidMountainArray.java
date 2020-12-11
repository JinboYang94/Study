package ChallengeDec;

public class ValidMountainArray {

  public boolean validMountainArray(int[] arr) {
    if (arr.length < 3) {
      return false;
    }
    boolean up = false;
    boolean down = false;
    for (int i = 1; i < arr.length - 1; i++) {
      // ever go up
      if (arr[i - 1] < arr[i]) {
        up = true;
      }
      // ever go down
      if (arr[i] > arr[i + 1]) {
        down = true;
      }
      // valley possibilities: \/ --- \_ _/
      // two peek-like: /- -\
      if ((arr[i - 1] >= arr[i] && arr[i] <= arr[i + 1])
          || (arr[i - 1] < arr[i] && arr[i] == arr[i + 1])
          || (arr[i - 1] == arr[i] && arr[i] > arr[i + 1])) {
        return false;
      }
    }
    return up && down;
  }

  // better solution 1:
  public boolean validMountainArray2(int[] arr) {
    if (arr.length < 3) {
      return false;
    }
    int i = 0;
    while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
      i++;
    }
    if (i == arr.length - 1 || i == 0) {
      return false;
    }
    while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
      i++;
    }
    return i == arr.length - 1;
  }
}
