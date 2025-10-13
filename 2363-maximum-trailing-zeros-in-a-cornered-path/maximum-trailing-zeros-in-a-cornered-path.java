class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // mat[i][j][0] -> count of 2s in grid[i][j]
        // mat[i][j][1] -> count of 5s in grid[i][j]
        int[][][] mat = new int[row + 2][col + 2][2];

        // Precompute the count of 2s and 5s for each cell
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                mat[i][j][0] = getTwos(grid[i - 1][j - 1]);
                mat[i][j][1] = getFives(grid[i - 1][j - 1]);
            }
        }

        // Prefix sums for rows (horizontal) and columns (vertical)
        int[][][] hor = new int[row + 2][col + 2][2];
        int[][][] ver = new int[row + 2][col + 2][2];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                hor[i][j][0] = hor[i][j - 1][0] + mat[i][j][0];
                hor[i][j][1] = hor[i][j - 1][1] + mat[i][j][1];
            }
        }

        for (int j = 1; j <= col; j++) {
            for (int i = 1; i <= row; i++) {
                ver[i][j][0] = ver[i - 1][j][0] + mat[i][j][0];
                ver[i][j][1] = ver[i - 1][j][1] + mat[i][j][1];
            }
        }

        int ans = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {

                int up2 = ver[i][j][0];
                int up5 = ver[i][j][1];

                int down2 = ver[row][j][0] - ver[i - 1][j][0];
                int down5 = ver[row][j][1] - ver[i - 1][j][1];

                int left2 = hor[i][j][0];
                int left5 = hor[i][j][1];

                int right2 = hor[i][col][0] - hor[i][j - 1][0];
                int right5 = hor[i][col][1] - hor[i][j - 1][1];

                // Up + Left
                int t2 = up2 + left2 - mat[i][j][0];
                int t5 = up5 + left5 - mat[i][j][1];
                ans = Math.max(ans, Math.min(t2, t5));

                // Up + Right
                t2 = up2 + right2 - mat[i][j][0];
                t5 = up5 + right5 - mat[i][j][1];
                ans = Math.max(ans, Math.min(t2, t5));

                // Down + Left
                t2 = down2 + left2 - mat[i][j][0];
                t5 = down5 + left5 - mat[i][j][1];
                ans = Math.max(ans, Math.min(t2, t5));

                // Down + Right
                t2 = down2 + right2 - mat[i][j][0];
                t5 = down5 + right5 - mat[i][j][1];
                ans = Math.max(ans, Math.min(t2, t5));
            }
        }

        return ans;
    }

    // Helper to count factors of 2
    private int getTwos(int num) {
        int ct = 0;
        while (num % 2 == 0 && num > 0) {
            ct++;
            num /= 2;
        }
        return ct;
    }

    // Helper to count factors of 5
    private int getFives(int num) {
        int ct = 0;
        while (num % 5 == 0 && num > 0) {
            ct++;
            num /= 5;
        }
        return ct;
    }
}
