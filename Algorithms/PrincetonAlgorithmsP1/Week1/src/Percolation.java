import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  private WeightedQuickUnionUF wuf;
  private WeightedQuickUnionUF backwash;
  private boolean[][] grid;
  private int N;  // size
  private int openSites;

  /**
   * Create a n-by-n grid with all sites blocked.
   *
   * @param n size of grid.
   */
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n should be larger than 0!");
    }

    grid = new boolean[n][n];
    wuf = new WeightedQuickUnionUF(n * n + 2);      // 2 virtual nodes on top and bottom
    backwash = new WeightedQuickUnionUF(n * n + 1);     // 1 virtual node on the top

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = false;
      }
    }

    this.N = n;

    for (int i = 1; i <= n; i++) {        // initialize two virtual nodes
      wuf.union(0, i);
      wuf.union(n * n + 1, n * n + 1 -i);
      backwash.union(0, i);
    }

  }

  /**
   * Covert (row, col) to the number of the sites.
   *
   * @param row the row index of a site.
   * @param col the column index of a site.
   * @return an int value representing the site.
   */
  private int index2num(int row, int col) {
    return (row - 1) * N + col;
  }

  /**
   * Open site (row, col) if it is not open already.
   *
   * @param row the row index of a site.
   * @param col the column index of a site.
   */
  public void open(int row, int col) {
    if (row > N || row < 1 || col > N || col < 1) {
      throw new IllegalArgumentException("argument should be within 1 to N!");
    } else {
      grid[row - 1][col - 1] = true;
      int num = index2num(row, col);

      if (col > 1 && isOpen(row, col - 1)) {     // left
        wuf.union(index2num(row, col - 1), num);
        backwash.union(index2num(row, col - 1), num);
      }
      if (row > 1 && isOpen(row - 1, col)) {      // up
        wuf.union(index2num(row - 1, col), num);
        backwash.union(index2num(row - 1, col), num);
      }
      if (col < N && isOpen(row, col + 1)) {      // right
        wuf.union(index2num(row, col + 1), num);
        backwash.union(index2num(row, col + 1), num);
      }
      if (row < N && isOpen(row + 1, col)) {      // down
        wuf.union(index2num(row + 1, col), num);
        backwash.union(index2num(row + 1, col), num);
      }
      openSites++;
    }
  }

  /**
   * Check the site status (open/close).
   *
   * @param row the row index of a site.
   * @param col the column index of a site.
   * @return a boolean value representing the status of the site.
   */
  public boolean isOpen(int row, int col) {
    if (row > N || row < 1 || col > N || col < 1) {
      throw new IllegalArgumentException("argument should be within 1 to N!");
    } else {
      return grid[row - 1][col - 1];  // -1 because the row/col index starts from 1
    }
  }

  /**
   * Check the site status (full/not full). Full means connecting to the top row.
   *
   * @param row the row index of a site.
   * @param col he column index of a site.
   * @return a boolean value representing the status of the site.
   */
  public boolean isFull(int row, int col) {
    if (row > N || row < 1 || col > N || col < 1) {
      throw new IllegalArgumentException("argument should be within 1 to N!");
    } else {
      return isOpen(row, col) && backwash.connected(index2num(row, col), 0);
    }
  }

  /**
   * Give number of open sites.
   *
   * @return an int value representing the number of the open sites.
   */
  public int numberOfOpenSites() {
    return openSites;
  }

  /**
   * Check the status of whole system.
   *
   * @return a boolean value representing the system percolates or not.
   */
  public boolean percolates() {
    if (N == 1) {
      return isOpen(1, 1);
    }

    return wuf.connected(0, N * N + 1);
  }

  /**
   * Main function for testing client (optional).
   *
   * @param args meaningless.
   */
  //public static void main(String[] args){}
}

