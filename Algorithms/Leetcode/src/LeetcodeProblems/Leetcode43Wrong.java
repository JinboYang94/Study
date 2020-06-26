package LeetcodeProblems;

/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * <p>
 * Example:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * </p>
 * Problem: exceed range, must use String representation
 */

class Leetcode43Wrong {

  public String multiply(String num1, String num2) {
    long sum = 0;

    for (int i = num2.length() - 1; i >= 0; i--) {
      int idx = num2.length() - 1 - i;  // track, for num and carry
      long carry = 0;
      long partAns = 0;

      for (int j = num1.length() - 1; j >= 0; j--) {
        long temp = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + carry;
        carry = temp / 10;
        long num = temp % 10;

        int idx2 = idx; // use idx2 here because idx will be used for the next loop
        while (idx2 > 0) { // add 0
          idx2--;
          num = 10 * num;
        }

        idx++;
        partAns += num;
      }

      if (carry > 0) {  // add the last carry when exits inner loop
        for (int k = 0; k < idx; k++) {
          carry = 10 * carry;
        }
      }
      sum += carry + partAns;
    }

    return sum + "";
  }
}
