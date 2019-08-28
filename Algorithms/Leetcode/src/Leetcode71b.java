import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Use another method, stack
 */

class Leetcode71b {

  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
    for (String str : path.split("/")) {
      if (!stack.isEmpty() && str.equals("..")) {
        stack.pop();
      } else if (!skip.contains(str)) {
        stack.push(str);
      }
    }

    String ans = "";
    for (String str : stack) {
      ans = "/".concat(str).concat(ans);
    }
    return ans.isEmpty() ? "/" : ans;
  }
}
