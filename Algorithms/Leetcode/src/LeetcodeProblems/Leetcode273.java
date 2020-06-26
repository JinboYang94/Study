package LeetcodeProblems;

/**
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 231 - 1.
 *
 * <p>
 * Example 1:
 *
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 *
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * </p>
 */

class Leetcode273 {

  private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
      "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
      "Seventeen", "Eighteen", "Nineteen"};
  private final String[] lessThan100 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
      "Seventy", "Eighty", "Ninety"};
  private final String[] moreThan100 = {"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    int i = 0;
    String words = "";
    while (num > 0) {
      // if num > 1000, first only handle the last 3 digits, update num to the remaining digits
      // like 12345, first handle 345, then handle 12 + moreThan100[1] which is 12 Thousand.
      if (num % 1000 > 0) {
        words = helper(num % 1000) + moreThan100[i] + " " + words;
      }
      num /= 1000;
      i++;
    }
    return words.trim();
  }

  private String helper(int num) {
    if (num == 0) {
      return "";
    } else if (num < 20) {  // 1 ~ 2 digits word < 20
      return lessThan20[num] + " ";
    } else if (num < 100) { // 2 digits word < 100
      return lessThan100[num / 10] + " " + helper(num % 10);
    } else {  // those >= 100, 3 digits words
      return lessThan20[num / 100] + " Hundred " + helper(num % 100);
    }
  }
}
