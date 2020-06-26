package LeetcodeProblems;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Note:
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 * <p>
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * </p>
 */

public class Leetcode223 {

  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int size1 = (C - A) * (D - B);
    int size2 = (G - E) * (H - F);

    // compute overlap
    int leftBound = Math.max(A, E);
    int rightBound = Math.min(C, G);
    int upBound = Math.min(D, H);
    int bottomBound = Math.max(B, F);

    int overlap = 0;
    if (rightBound > leftBound && upBound > bottomBound) {
      overlap = (rightBound - leftBound) * (upBound - bottomBound);
    }
    return size1 + size2 - overlap;
  }
}
