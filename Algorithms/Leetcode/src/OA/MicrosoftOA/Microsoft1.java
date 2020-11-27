package OA.MicrosoftOA;


// Leetcode 1497
public class Microsoft1 {

  public boolean canArrange(int[] arr, int k) {
    int[] mod = new int[k];
    for (int num : arr) {
      mod[(num % k + k) % k]++;
    }

    if (mod[0] % 2 != 0) {
      return false;
    }

    for (int i = 1; i < Math.ceil(k / 2.0); i++) {
      if (mod[i] != mod[k - i]) {
        return false;
      }
    }

    return true;
  }
}
