/**
 * Try to use another matrix, change initialization. FAIL, CANNOT PASS 1143/1146:
 * "pneumonoultramicroscopicsilicovolcanoconiosis"
 * "ultramicroscopically"
 * why?
 * Solved: because first row and col initialization wrong. 'u' in second word appears twice in first
 * word which can be used as part of correct answer. but this is redundant, need to be removed, not
 * just copy [i - 1] value.
 * another case: "ahshorsbed" "horse", two h in word1 matters if no ct added.
 * solution:
 * So add two variables ct1 and ct2 as count, only one equivalent character will be counted as no
 * need to change.
 */

class Leetcode72b {

  public int minDistance(String word1, String word2) {
    if (word1.length() == 0) {
      return word2.length();
    }
    if (word2.length() == 0) {
      return word1.length();
    }

    int m = word1.length();
    int n = word2.length();
    int[][] cost = new int[n][m];
    int ct1 = 0;  // avoid duplicate, only first time equivalence counted as part of the other word.
    for (int i = 0; i < n; i++) {
      if (ct1 == 0 && word2.charAt(i) == word1.charAt(0)) {
        cost[i][0] = i == 0 ? 0 : cost[i - 1][0];
        ct1++;
      } else {
        cost[i][0] = i == 0 ? 1 : cost[i - 1][0] + 1;
      }
    }
    int ct2 = 0;  // avoid duplicate
    for (int i = 0; i < m; i++) {
      if (ct2 == 0 && word1.charAt(i) == word2.charAt(0)) {
        cost[0][i] = i == 0 ? 0 : cost[0][i - 1];
        ct2++;
      } else {
        cost[0][i] = i == 0 ? 1 : cost[0][i - 1] + 1;
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (word1.charAt(j) == word2.charAt(i)) {
          cost[i][j] = cost[i - 1][j - 1];
        } else {
          int replaceOp = cost[i - 1][j - 1];
          int deleteOp = cost[i - 1][j];
          int insertOp = cost[i][j - 1];
          cost[i][j] = Math.min(Math.min(deleteOp, insertOp), replaceOp) + 1;
        }
      }
    }
    return cost[n - 1][m - 1];
  }
}
