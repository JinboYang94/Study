import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * <p>
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * </p>
 */

class Leetcode6 {

  public String convert(String s, int numRows) {
    if (numRows <= 1) {   // because if numRows <= 1, there must not have a up or down operation
      return s;
    }

    List<StringBuilder> temp = new ArrayList<>();

    for (int i = 0; i < Math.min(s.length(), numRows); i++) {  // how many rows are in explanation
      temp.add(new StringBuilder());
    }

    int cur = 0;  // track the row of the current element
    boolean up = true;  // show the direction

    for (char c : s.toCharArray()) {
      temp.get(cur).append(c);  // for element which index = cur, append c to StringBuilder
      if (cur == 0 || cur == numRows - 1) { // reach bottom or top, change direction
        up = !up;
      }
      cur += up == false ? 1 : -1;  // change current row through String loop
    }

    StringBuilder ans = new StringBuilder();  // store output
    for (StringBuilder sb : temp) {
      ans.append(sb);
    }
    return ans.toString();
  }
}
