import javafx.beans.binding.StringBinding;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * <p>
 * Example:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * </p>
 */

class Leetcode7 {

  public int reverse(int x) {
    boolean sign;

    if (x == Math.abs(x)) {
      sign = true;
    } else {
      sign = false;
      x = Math.abs(x);
    }

    StringBuilder sb = new StringBuilder();
    char[] chArray = Integer.toString(x).toCharArray();

    for (int i = chArray.length - 1; i >= 0; i--) {
      sb.append(chArray[i]);
    }

    try {
      if (sign) {
        return Integer.valueOf(sb.toString());
      } else {
        return -1 * Integer.valueOf(sb.toString());
      }
    } catch (NumberFormatException e) {
      return 0;
    }

  }
}
