package LeetcodeProblems;

/**
 * 67 uses brute force, here try another.
 */

class Leetcode67b {

  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int sum = carry;  // add binary one by one digit
      if (j >= 0) { // if b not exhausted, add this digit to sum
        sum += b.charAt(j--) - '0';
      }
      if (i >= 0) { // if a not exhausted, add this digit to sum
        sum += a.charAt(i--) - '0';
      }

      sb.append(sum % 2); // sum can only be 0, 1, 2, 3. but sum % 2 will be the digit left on this
      carry = sum / 2;  // position. carry will be sum / 2
    }

    if (carry != 0) { // if carry still not 0, add to sb
      sb.append(carry);
    }
    return sb.reverse().toString();
  }
}
