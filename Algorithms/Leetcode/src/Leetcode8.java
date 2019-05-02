/**
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a
 * numerical value.
 * The string can contain additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if
 * no such sequence exists because either str is empty or it contains only whitespace characters, no
 * conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * Note:
 * Only the space character ' ' is considered as whitespace character. Assume we are dealing with an
 * environment which could only store integers within the 32-bit signed integer range: [−231,  231 −
 * 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or
 * INT_MIN (−231) is returned.
 *
 * <p>
 * Example:
 * Input: "42"
 * Output: 42
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 * </p>
 */

class Leetcode8 {

  public int myAtoi(String str) {
    int ans = 0;
    int sign = 1;
    boolean hasSign = false;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '+' && !hasSign) {
        hasSign = true;
        continue;
      }
      if (str.charAt(i) == '-' && !hasSign) {
        hasSign = true;
        sign = -1;
        continue;
      }
      if (str.charAt(i) == ' ' && !hasSign) {
        continue;
      }

      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        hasSign = true;
        int temp = str.charAt(i) - '0';
        if (sign * ans > Integer.MAX_VALUE / 10 || (sign * ans == Integer.MAX_VALUE / 10 && sign
            * temp > 7)) {
          return Integer.MAX_VALUE;
        }
        if (sign * ans < Integer.MIN_VALUE / 10 || (sign * ans == Integer.MIN_VALUE / 10 && sign
            * temp < -8)) {
          return Integer.MIN_VALUE;
        }
        ans = ans * 10 + temp;
      } else {
        return sign * ans;
      }
    }

    return sign * ans;
  }
}
