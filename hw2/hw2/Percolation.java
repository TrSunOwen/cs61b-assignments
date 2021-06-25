package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N; // The size of the whole grid
    private boolean[][] flagOpen; // Store the flag about whether one block is blocked in the grid.

    private int yTo1D(int r, int c) {
        return (N * r + c);
    }

    /** Create N-by-N grid, with all sites initially blocked */
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }

        /** The array flagOpen stores the status of all sites (blocked or not).
         *  After initialization, all the sites are blocked (false).
         * */
        flagOpen = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flagOpen[i][j] = false;
            }
        }


    }

    /** Open the site (row, col) if it is not open already */
    public void open(int row, int col)
    public boolean isOpen(int row, int col)  // is the site (row, col) open?
    public boolean isFull(int row, int col)  // is the site (row, col) full?
    public int numberOfOpenSites()           // number of open sites
    public boolean percolates()              // does the system percolate?

    public static void main(String[] args)   // use for unit testing (not required)
}
