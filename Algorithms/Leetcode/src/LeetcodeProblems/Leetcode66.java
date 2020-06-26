package LeetcodeProblems;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * <p>
 *  Example:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * </p>
 */

class Leetcode66 {

  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] != 9) {
        digits[i]++;
        break;
      } else {
        digits[i] = 0;
      }
    }

    if (digits[0] == 0) {
      int[] ret = new int[digits.length + 1];
      ret[0] = 1;
      return ret;
    }

    return digits;
  }
}
