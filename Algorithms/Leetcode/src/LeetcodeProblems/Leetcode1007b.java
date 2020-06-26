package LeetcodeProblems;

/**
 * Another faster solution. Use array instead of hash.
 */

class Leetcode1007b {

  public int minDominoRotations(int[] A, int[] B) {
    int len = A.length;
    int[] countA = new int[7];
    int[] countB = new int[7];
    int[] same = new int[7];
    for (int i = 0; i < len; i++) {
      countA[A[i]]++;
      countB[B[i]]++;
      if (A[i] == B[i]) {
        same[A[i]]++;
      }
    }
    for (int i = 1; i <= 6; i++) {
      if (countA[i] + countB[i] - same[i] == len) {
        return Math.min(countA[i], countB[i]) - same[i];
      }
    }
    return -1;
  }
}
