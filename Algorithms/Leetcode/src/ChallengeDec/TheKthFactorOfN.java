package ChallengeDec;

import java.util.Arrays;

public class TheKthFactorOfN {

  public int kthFactor(int n, int k) {
    int[] factors = new int[n];
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        factors[count++] = i;
      }
    }
    factors = Arrays.copyOfRange(factors, 0, count);
    Arrays.sort(factors);
    return k <= factors.length ? factors[k - 1] : -1;
  }
}
