import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * <p>
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * </p>
 */

class Leetcode131 {

  public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    dfs(ans, s, new ArrayList<>(), 0);
    return ans;
  }

  private void dfs(List<List<String>> ans, String s, List<String> temp, int index) {
    if (index == s.length()) {
      ans.add(new ArrayList<>(temp));
    }
    for (int i = index; i < s.length(); i++) {
      String part = s.substring(index, i + 1);
      if (isPalindrome(part)) {
        temp.add(part);
        dfs(ans, s, temp, i + 1);
        temp.remove(temp.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s) {
    int len = s.length();
    int i = 0;
    int j = len - 1;
    while (i <= j) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        return false;
      }
    }
    return true;
  }
}
