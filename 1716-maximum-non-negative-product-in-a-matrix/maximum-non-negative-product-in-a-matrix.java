class Solution {
    public int maxProductPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        long MOD = 1_000_000_007;

        // DP arrays to store max and min products
        long[][] maxProduct = new long[row][col];
        long[][] minProduct = new long[row][col];

        // Initialize starting cell
        maxProduct[0][0] = minProduct[0][0] = grid[0][0];

        // Fill first column
        for (int i = 1; i < row; i++) {
            maxProduct[i][0] = minProduct[i][0] = maxProduct[i - 1][0] * grid[i][0];
        }

        // Fill first row
        for (int j = 1; j < col; j++) {
            maxProduct[0][j] = minProduct[0][j] = maxProduct[0][j - 1] * grid[0][j];
        }

        // Fill the rest of the grid
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] >= 0) {
                    maxProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]) * grid[i][j];
                    minProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]) * grid[i][j];
                } else {
                    maxProduct[i][j] = Math.min(minProduct[i - 1][j], minProduct[i][j - 1]) * grid[i][j];
                    minProduct[i][j] = Math.max(maxProduct[i - 1][j], maxProduct[i][j - 1]) * grid[i][j];
                }
            }
        }

        // Result is the maximum product modulo MOD
        long result = maxProduct[row - 1][col - 1];
        return result >= 0 ? (int) (result % MOD) : -1;
    }
}
