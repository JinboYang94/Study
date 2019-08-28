import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 *
 * <p>
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * </p>
 */

class Leetcode119 {

  public List<Integer> getRow(int rowIndex) {
    List<List<Integer>> allAns = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      List<Integer> ans = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          ans.add(1);
        } else {
          List<Integer> lastRow = allAns.get(i - 1);
          ans.add(lastRow.get(j - 1) + lastRow.get(j));
        }
      }
      allAns.add(ans);
    }
    return allAns.get(allAns.size() - 1);
  }
}
