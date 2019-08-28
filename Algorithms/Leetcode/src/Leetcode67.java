/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * <p>
 *  Example:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * </p>
 */

class Leetcode67 {

  public String addBinary(String a, String b) {
    int length;
    if (a.length() < b.length()) {
      length = b.length();
      String temp = a;
      a = b;
      b = temp;
    } else {
      length = a.length();
    }

    StringBuilder ret =  new StringBuilder(length + 1);
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    while (i >= 0) {
      if (j < 0) {
        if (carry == 1 && a.charAt(i) == '1') {
          ret.append(0);
          carry = 1;
        } else {
          ret.append(a.charAt(i) - '0' + carry);
          carry = 0;
        }
      } else {
        if (a.charAt(i) == '1' && b.charAt(j) == '1') {
          ret.append(carry);
          carry = 1;
        }

        if (a.charAt(i) == '1' && b.charAt(j) == '0') {
          if (carry == 1) {
            ret.append(0);
            carry = 1;
          } else {
            ret.append(1);
            carry = 0;
          }
        }

        if (a.charAt(i) == '0' && b.charAt(j) == '1') {
          if (carry == 1) {
            ret.append(0);
            carry = 1;
          } else {
            ret.append(1);
            carry = 0;
          }
        }

        if (a.charAt(i) == '0' && b.charAt(j) == '0') {
          ret.append(carry);
          carry = 0;
        }
      }
      i--;
      j--;
    }

    if (carry == 1) {
      ret.append(1);
    }

    return ret.reverse().toString();
  }
}
