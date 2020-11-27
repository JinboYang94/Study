package ChallengeNov;

public class SmallestIntegerDivisibleByK {

  public int smallestRepunitDivByK(int K) {
    int reminder = 0;
    for (int len = 1; len <= K; len++) {
      reminder = (reminder * 10 + 1) % K;
      if (reminder == 0) {
        return len;
      }
    }
    return -1;
  }
}
