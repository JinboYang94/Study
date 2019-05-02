import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

  private double[] ret;   // an array store results.
  private int N;  // grid length.
  private int T;  // trials times.

  /**
   * Perform trials times independent experiments on a n-by-b grid.
   *
   * @param n grid length
   * @param trials trail numbers
   */
  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }

    this.N = n;
    this.T = trials;

    Percolation p;
    ret = new double[T];

    for (int i = 0; i < T; i++) {
      p = new Percolation(N);
      while (!p.percolates()) {
        int r = StdRandom.uniform(1, N + 1);
        int c = StdRandom.uniform(1, N + 1);

        if (!p.isOpen(r, c)) {
          p.open(r, c);
        }
      }
      ret[i] = (double) p.numberOfOpenSites() / (N * N);
    }
  }

  /**
   * Sample mean of percolation threshold.
   *
   * @return a double value representing the mean.
   */
  public double mean() {
    return StdStats.mean(ret);
  }

  /**
   * Sample standard deviation of percolation threshold.
   *
   * @return a double value representing the standard deviation.
   */
  public double stddev() {
    return StdStats.stddev(ret);
  }

  /**
   * Low ending point of 95% confidence interval.
   *
   * @return a double value representing the low confidence interval.
   */
  public double confidenceLo() {
    return StdStats.mean(ret) - 1.96 * StdStats.stddev(ret) / Math.sqrt(T);
  }

  /**
   * High ending point of 95% confidence interval.
   *
   * @return a double value representing the high confidence interval.
   */
  public double confidenceHi() {
    return StdStats.mean(ret) + 1.96 * StdStats.stddev(ret) / Math.sqrt(T);
  }

  /**
   * Test client.
   *
   * @param args meaningless.
   */
  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    int T = Integer.parseInt(args[1]);
    PercolationStats p = new PercolationStats(N, T);
    StdOut.printf("mean                    = %f%n", p.mean());
    StdOut.printf("stddev                  = %f%n", p.stddev());
    StdOut.printf("confidence interval = %f, %f%n", p.confidenceLo(), p.confidenceHi());
  }

}
