package OA.BloombergLP;

import java.util.Stack;

/**
 * Leetcode 394.
 */

public class Bloomberg4 {

  public String decodeString(String s) {
    StringBuilder ans = new StringBuilder();
    Stack<Integer> number = new Stack<>();
    Stack<StringBuilder> stack = new Stack<>();
    int num = 0;
    for (char ch : s.toCharArray()) {
      if (ch <= '9') {
        num = 10 * num + ch - '0';
      } else if (ch == '[') {
        number.push(num);
        num = 0;
        stack.push(ans);
        ans = new StringBuilder();
      } else if (ch == ']') {
        StringBuilder toBeAppended = ans;
        ans = stack.pop();
        int repeatTimes = number.pop();
        for (int i = 0; i < repeatTimes; i++) {
          ans.append(toBeAppended);
        }
      } else {
        ans.append(ch);
      }
    }
    return ans.toString();
  }
}
