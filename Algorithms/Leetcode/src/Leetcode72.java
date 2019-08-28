/**
 * Given two words word1 and word2,
 * find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * <p>
 * Example:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * </p>
 * <p>
 * "horse -> ros" explanation: 2D array (Ø means empty case)
 *   Ø r o s
 * Ø 0 1 2 3
 * h 1 1 2 3
 * o 2 2 1 2
 * r 3 2 2 2
 * s 4 3 3 2
 * e 5 4 4 3
 * First time using this matrix: (but in code is the above one)
 *   Ø h o r s e
 * Ø 0 1 2 3 4 5
 * r 1 1 2 2 3 4
 * o 2 2 1 2 3 4
 * s 3 3 2 2 2 3
 * Here matrix size is 4 * 6, first col and row are initialized for computing the real matrix which
 * is 3 * 5. This matrix setup is bottom-up method.
 * </p>
 */

class Leetcode72 {

  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] cost = new int[m + 1][n + 1];
    for (int i = 0; i < m + 1; i++) {
      cost[i][0] = i;
    }
    for (int i = 0; i < n + 1; i++) {
      cost[0][i] = i;
    }

    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) { // because word index different, need - 1
          cost[i][j] = cost[i - 1][j - 1];
        } else {
          int insertOp = cost[i][j - 1];  // from word1 to word2 by inserting
          int deleteOp = cost[i - 1][j];  // from word1 to word2 by deleting
          int replaceOp = cost[i - 1][j - 1]; // from word1 to word2 by replacing
          // insert and delete are equivalent, so choose either and compare with replacing.
          // plus 1 because this position using replace op will cost 1.
          cost[i][j] = Math.min(Math.min(insertOp, deleteOp), replaceOp) + 1;
        }
      }
    }
    return cost[m][n];
  }
}
