/**
 * Given an input string (s) and a pattern (p),
 * implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
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
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * </p>
 */

class Leetcode44 {

  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[s.length()][p.length()] = true;

    for (int i = s.length(); i >= 0; i--) {
      for (int j = p.length(); j >= 0; j--) {
        if (i == s.length() && j == p.length()) {
          continue;
        }

        boolean firstMatch = (i < s.length() && j < p.length()
            && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' || p.charAt(j) == '*'));

        // if p.charAt(j) is '*',
        if (j < p.length() && p.charAt(j) == '*') {
          dp[i][j] = dp[i][j + 1] || firstMatch && dp[i + 1][j];
        } else {
          dp[i][j] = firstMatch && dp[i + 1][j + 1];  // notice sequence
        }

      }
    }

    return dp[0][0];
  }
}
