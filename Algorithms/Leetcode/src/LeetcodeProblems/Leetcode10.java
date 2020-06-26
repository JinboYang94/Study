package LeetcodeProblems;

/**
 * Given an input string (s) and a pattern (p),
 * implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * <p>
 * Example:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * </p>
 * Tag: DP using 2D boolean table
 */

class Leetcode10 {

  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;

    // if s is ... and p is like c*..., we need to set c* to empty, which means c* is canceled.
    // that guarantees the * in second position is considered.
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*' && dp[0][i - 1]) {
        dp[0][i + 1] = true;
      }
    }

    // set status for other positions in 2D boolean table.
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {

        // if character equals or p.charAt() == '.', this dp will depend on dp[i - 1][j - 1]
        // but for the reason i and j starts from 0, use this instead.
        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        }
        // if p.charAt() == '*', this dp has two situations:
        // 1. The p's character before "*" does not match s' ones. Like abb and abc*,
        //    we should regard "*" as "cancel" which means the abc* becomes ab, this dp
        //    depends on dp[i][j - 2].
        // 2. The p's character before "*" is '.' or matches s' ones. Like abb and ab.*
        //    or abb and abb*, again some possibilities:
        //    (1)dp[i][j] = dp[i][j - 1], which a* is a
        //    (2)dp[i][j] = dp[i - 1][j], which a* is multiple a
        //    (3)dp[i][j] = dp[i][j - 2], which a* is empty
        if (p.charAt(j) == '*') {
          if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
            dp[i + 1][j + 1] = dp[i + 1][j - 1];
          } else {
            dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
          }
        }

      }
    }

    return dp[s.length()][p.length()];
  }
}
