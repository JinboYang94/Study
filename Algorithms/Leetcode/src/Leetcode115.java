/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions of
 * the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * <p>
 * Example:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 * </p>
 */

class Leetcode115 {

  public int numDistinct(String s, String t) {
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i < s.length() + 1; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i < t.length() + 1; i++) {
      dp[0][i] = 0;
    }

    for (int i = 1; i < s.length() + 1; i++) {
      for (int j = 1; j < t.length() + 1; j++) {
        // if not match, then delete this character in s is useless. So we have same number of
        // solutions as previous character in s
        if (s.charAt(i - 1) != t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j];
        } else {
          // if match, two cases:
          // 1. we use these two characters for matching subsequence, then it equals to
          //    [i - 1][j - 1]
          // 2. we do not use them for matching subsequence, then it equals to [i - 1][j]
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
        }
      }
    }
    return dp[s.length()][t.length()];
  }
}
