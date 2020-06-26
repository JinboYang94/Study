package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 * Return the minimum number of rotations so that all the values in A are the same,
 * or all the values in B are the same.
 * If it cannot be done, return -1.
 * Note:
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 * Tag: Simulation, not fast.
 * @see <a href="https://assets.leetcode.com/uploads/2019/03/08/domino.png">https://assets.leetcode.com/uploads/2019/03/08/domino.png</a>
 *
 * <p>
 * Example 1:
 * Image shown above.
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * Example 2:
 *
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 * </p>
 */

class Leetcode1007 {

  public int minDominoRotations(int[] A, int[] B) {
    if (A.length == 0 || B.length == 0) {
      return 0;
    }
    int len = A.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      if (A[i] == B[i]) {
        map.put(A[i], map.getOrDefault(A[i], 0) + 1);
      } else {
        map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        map.put(B[i], map.getOrDefault(B[i], 0) + 1);
      }
    }

    for (Integer i : map.keySet()) {
      if (map.get(i) == len) {
        int countA = 0;
        int countB = 0;
        for (int j = 0; j < len; j++) {
          if (i == A[j]) {
            countA++;
          }
          if (i == B[j]) {
            countB++;
          }
        }
        return len - Math.max(countA, countB);
      }
    }
    return -1;
  }
}
