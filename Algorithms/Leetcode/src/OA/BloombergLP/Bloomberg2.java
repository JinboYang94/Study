package OA.BloombergLP;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string print all subsets (not permutations).
 * Eg. String "abc" should output:
 * empty string
 * a
 * b
 * c
 * ab
 * bc
 * ac
 * abc
 */

public class Bloomberg2 {

  public List<String> getSubsets(String s) {
    List<String> ans = new ArrayList<>();
    char[] charArray = s.toCharArray();
    backtrack(ans, new ArrayList<>(), charArray, 0);
    return ans;
  }

  private void backtrack(List<String> ans, List<Character> temp, char[] chs, int index) {
    ans.add(convert(new ArrayList<>(temp)));
    for (int i = index; i < chs.length; i++) {
      temp.add(chs[i]);
      backtrack(ans, temp, chs, i + 1);
      temp.remove(temp.size() - 1);
    }
  }

  private String convert(List<Character> list) {
    StringBuilder sb = new StringBuilder();
    for (char ch : list) {
      sb.append(ch);
    }
    return sb.toString();
  }
}
