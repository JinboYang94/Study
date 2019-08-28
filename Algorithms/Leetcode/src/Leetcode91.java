import java.util.HashMap;
/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * <p>
 * Example:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * </p>
 */

class Leetcode91 {

  public int numDecodings(String s) {
    HashMap<Integer, Integer> memo = new HashMap<>();
    return iterate(s, 0, memo);
  }

  private int iterate(String s, int index, HashMap<Integer, Integer> memo) {
    if (index == s.length()) {  // already the end
      return 1;
    } else if (s.charAt(index) == '0') {  // '0' not valid
      return 0;
    } else {  // iterate from two basic cases: 1 character or 2 character
      Integer m = memo.get(index);
      if (m != null) {
        return m;
      }
      int ans1 = iterate(s, index + 1, memo);
      int ans2 = 0;
      if (index < s.length() - 1) { //qualify
        int first = (s.charAt(index) - '0') * 10;
        int second = s.charAt(index + 1) - '0';
        if (first + second <= 26) {
          ans2 = iterate(s, index + 2, memo);
        }
      }
      memo.put(index, ans1 + ans2);
      return ans1 + ans2;
    }
  }
}
