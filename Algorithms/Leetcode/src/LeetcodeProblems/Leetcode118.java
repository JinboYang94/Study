package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * <p>
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * </p>
 */

class Leetcode118 {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Integer> thisRow = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) { // two sides set to 1
          thisRow.add(1);
        } else {
          List<Integer> lastRow = ans.get(i - 1); // get values from last row
          thisRow.add(lastRow.get(j - 1) + lastRow.get(j));
        }
      }
      ans.add(thisRow);
    }
    return ans;
  }
}
