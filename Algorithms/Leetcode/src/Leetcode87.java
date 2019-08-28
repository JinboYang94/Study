/**
 * Given a string s1,
 * we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children,
 * it produces a scrambled string "rgeat".
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at",
 * it produces a scrambled string "rgtae".
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * <p>
 * Example:
 *
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 *
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 * </p>
 */

class Leetcode87 {

  public boolean isScramble(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    int len = s1.length();
    // [cut length][s1 start j][s2 start k], means whether "s1 from j to j + cut length" equals
    // to "s2 from k to k + cut length" or not
    boolean[][][] dp = new boolean[len + 1][len][len];
    for (int i = 1; i <= len; i++) {  // loop all possible cut lengths from left
      for (int j = 0; j + i <= len; j++) {  // s1 starts at j
        for (int k = 0; k + i <= len; k++) {  // s2 starts at k
          if (i == 1) { // no need to cut anymore
            dp[i][j][k] = s1.charAt(j) == s2.charAt(k);
          } else {
            for (int s = 1; s < i; s++) { // loop left part length after cut
              //s1 left == s2 left && s1 right == s2 right || s1 right == s2 left && s1 left
              // == s2 right
              dp[i][j][k] = dp[s][j][k] && dp[i - s][j + s][k + s]
                  || dp[s][j][k + i - s] && dp[i - s][j + s][k];
              if (dp[i][j][k]) {
                break;
              }
            }
          }
        }
      }
    }
    return dp[len][0][0];
  }
}
