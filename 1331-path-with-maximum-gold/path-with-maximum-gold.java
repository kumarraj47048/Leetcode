class Solution {
    int max = 0;
    
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[m][n]; // Initialize visited array for each starting cell
                    func(grid, i, j, 0, visited);
                }
            }
        }
        return max;
    }
    
    public void func(int[][] grid, int i, int j, int sum, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            max = Math.max(max, sum);
            return;
        }
        
        visited[i][j] = true;
        sum += grid[i][j];
        
        func(grid, i - 1, j, sum, visited); // Move up
        func(grid, i + 1, j, sum, visited); // Move down
        func(grid, i, j - 1, sum, visited); // Move left
        func(grid, i, j + 1, sum, visited); // Move right
        
        // Backtrack
        visited[i][j] = false;
    }
}
