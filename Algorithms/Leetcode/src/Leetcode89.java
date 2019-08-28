import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * <p>
 * Example:
 *
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 *
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 *              A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 *              Therefore, for n = 0 the gray code sequence is [0].
 * </p>
 */

class Leetcode89 {

  public List<Integer> grayCode(int n) {
    List<Integer> ans = new ArrayList<>();
    ans.add(0);
    for (int i = 0; i < n; i++) {
      int add = 1 << i; // to be added, 2^(n - 1)
      for (int j = ans.size() - 1; j >= 0; j--) {
        ans.add(ans.get(j) + add);
      }
    }
    return ans;
  }
}
