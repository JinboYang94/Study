/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * <p>
 * Example:
 *
 * Input: "III"
 * Output: 3
 *
 * Input: "IV"
 * Output: 4
 *
 * Input: "IX"
 * Output: 9
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * </p>
 */

class Leetcode13 {

  public int romanToInt(String s) {
    int[] nums = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'I') {
        nums[i] = 1;
      } else if (s.charAt(i) == 'V') {
        nums[i] = 5;
      } else if (s.charAt(i) == 'X') {
        nums[i] = 10;
      } else if (s.charAt(i) == 'L') {
        nums[i] = 50;
      } else if (s.charAt(i) == 'C') {
        nums[i] = 100;
      } else if (s.charAt(i) == 'D') {
        nums[i] = 500;
      } else if (s.charAt(i) == 'M') {
        nums[i] = 1000;
      } else {
        throw new IllegalArgumentException("Not valid argument.");
      }
    }

    int sum = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      if (nums[i] < nums[i + 1]) {
        sum -= nums[i];
      } else {
        sum += nums[i];
      }
    }
    return sum + nums[s.length() - 1];
  }
}
