package LeetcodeProblems;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * <p>
 * Example:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * </p>
 */

class Leetcode97 {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1]; // state
    dp[0][0] = true;  // initialize
    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = dp[i - 1][0] && s2.charAt(i - 1) == s3.charAt(i - 1);
    }
    for (int i = 1; i < dp[0].length; i++) {
      dp[0][i] = dp[0][i - 1] && s1.charAt(i - 1) == s3.charAt(i  - 1);
    }
    // function
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        dp[i][j] = (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1))
            || (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1));
      }
    }
    return dp[s2.length()][s1.length()];  // result
  }
}
