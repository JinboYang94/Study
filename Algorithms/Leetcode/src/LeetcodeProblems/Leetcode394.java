package LeetcodeProblems;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string],
 * where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * <p>
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * </p>
 */

class Leetcode394 {

  public String decodeString(String s) {
    String ans = "";
    Stack<Integer> count = new Stack<>();
    Stack<String> stack = new Stack<>();
    int i = 0;
    while (i < s.length()) {
      // get multiply times
      if (s.charAt(i) <= '9') {
        int multi = 0;
        while (s.charAt(i) <= '9') {
          multi = 10 * multi + (s.charAt(i) - '0');
          i++;
        }
        count.push(multi);
      } else if (s.charAt(i) == '[') {  //
        stack.push(ans);
        ans = "";
        i++;
      } else if (s.charAt(i) == ']') {
        StringBuilder sb = new StringBuilder(stack.pop());
        int times = count.pop();
        for (int j = 0; j < times; j++) {
          sb.append(ans);
        }
        ans = sb.toString();
        i++;
      } else {
        ans += s.charAt(i++);
      }
    }
    return ans;
  }
}
