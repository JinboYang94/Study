import java.util.ArrayList;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * <p>
 * Example:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence
 *              and not a substring.
 * </p>
 */

class Leetcode3 {

  public int lengthOfLongestSubstring(String s) {
    //ArrayList<Character> temp = new ArrayList<>();
    int ans = 0;

    for (int i = 0; i < s.length(); i++) {
      ArrayList<Character> temp = new ArrayList<>();
      int j = i;
      while (j < s.length() && !temp.contains(s.charAt(j))) {
        temp.add(s.charAt(j));
        j++;
      }
      ans = Math.max(ans, j - i);
    }

    return ans;
  }
}
