package LeetcodeProblems;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and
 * empty spaces . The integer division should truncate toward zero.
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 * <p>
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * </p>
 */

public class Leetcode227 {

  public int calculate(String s) {
    int len = s.length();
    int ret = 0;
    boolean prevDigit = false;
    int tempNum = 0;
    char sign = '+';
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == ' ' && i != len - 1) {
        continue;
      }
      // System.out.println(prevDigit);
      if (Character.isDigit(s.charAt(i))) {
        tempNum = prevDigit ? (tempNum * 10 + s.charAt(i) - '0') : (s.charAt(i) - '0');
        prevDigit = true;
        // System.out.println(tempNum);
      }
      if (!Character.isDigit(s.charAt(i)) || i == len - 1) {
        prevDigit = false;
        if (sign == '+') {
          stack.push(tempNum);
        } else if (sign == '-') {
          stack.push(-tempNum);
        } else if (sign == '*') {
          stack.push(stack.pop() * tempNum);
        } else if (sign == '/') {
          stack.push(stack.pop() / tempNum);
        } else {
          System.out.println("Unexpected Error");
        }
        System.out.println(stack);
        System.out.println(sign);
        sign = s.charAt(i);
      }
    }
    for (int i : stack) {
      ret += i;
    }
    return ret;
  }
}
