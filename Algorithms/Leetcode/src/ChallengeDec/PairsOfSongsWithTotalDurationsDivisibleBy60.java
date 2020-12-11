package ChallengeDec;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

  public int numPairsDivisibleBy60(int[] time) {
    int[] mod = new int[60];
    int ret = 0;
    for (int song : time) {
      if (song % 60 == 0) {
        // get pairs
        ret += mod[song % 60];
        mod[song % 60]++;
      } else {
        // get pairs
        ret += mod[60 - song % 60];
        mod[song % 60]++;
      }
    }
    return ret;
  }
}
