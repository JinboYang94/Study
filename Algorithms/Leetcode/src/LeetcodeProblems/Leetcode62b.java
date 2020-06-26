package LeetcodeProblems;

/**
 * Tag: translate the problem into permutation!
 */

class Leetcode62b {

  public int uniquePaths(int m, int n) {
    double up = 1;
    double down = 1;
    // for cancel out, I don't understand why do cancel out, but if no, error
    int tar = m > n ? m - 1 : n - 1;
    int tar2 = m > n ? n - 1 : m - 1;
    // totally we need m + n - 2 steps
    for (int i = m + n - 2; i > tar; i--) {
      up *= i;
    }
    for (int i = 2; i <= tar2; i++) {
      down *= i;
    }
    // permutation formula is C(a, b) = a! / (b! * (a - b)!), here a = m + n - 2, b = n - 1 or m - 1
    // cancel out => a * (a - 1) * ... * (a - b + 1) / b!
    return (int) (up / down);
  }
}
