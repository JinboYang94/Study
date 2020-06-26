package LeetcodeProblems;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 *
 * <p>
 * Example:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Input: "cbbd"
 * Output: "bb"
 * </p>
 */

class Leetcode5 {   // zhongxin kuosanfa

  public String longestPalindrome(String s) {
    String ans = "";
    if (s == null || s.length() == 0) {
      return ans;
    }

    String ans1 = "";
    String ans2 = "";
    for (int i = 0; i < s.length(); i++) {
      String temp1 = checkPalindrome(s, i, i);
      String temp2 = checkPalindrome(s, i, i + 1);
      if (temp1.length() > ans1.length()) {
        ans1 = temp1;
      }
      if (temp2.length() > ans2.length()) {
        ans2 = temp2;
      }

      if (ans1.length() > ans2.length()) {
        ans = ans1;
      } else {
        ans = ans2;
      }
    }

    return ans;
  }

  private String checkPalindrome(String s, int left, int right) {
    String subS = "";
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }

    String temp = s.substring(left + 1, right);
    if (temp.length() > subS.length()) {
      subS = temp;
    }

    return subS;
  }
}
