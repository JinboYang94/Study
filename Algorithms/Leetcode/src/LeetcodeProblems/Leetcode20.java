package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * <p>
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 * </p>
 */

class Leetcode20 {

  public boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      // if left parentheses, push into stack
      if (map.containsValue(ch)) {
        stack.push(ch);
      } else {
        // if right, see if the top is corresponding left parentheses.
        char top = stack.isEmpty() ? 'x' : stack.pop();
        if (top != map.get(ch)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
