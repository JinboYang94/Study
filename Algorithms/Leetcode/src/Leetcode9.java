/**
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * <p>
 * Example:
 *
 * Input: 121
 * Output: true
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * </p>
 */

class Leetcode9 {

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    } else {
      String str = Integer.toString(x);
      char[] strArray = str.toCharArray();
      StringBuilder sb = new StringBuilder();

      for (int i = strArray.length - 1; i >= 0; i--) {
        sb.append(strArray[i]);
      }

      if (sb.toString().equals(str)) {
        return true;
      } else {
        return false;
      }
    }
  }
}
