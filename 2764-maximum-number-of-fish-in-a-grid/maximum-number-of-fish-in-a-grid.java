class Solution {
    public int findMaxFish(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] > 0) { // Start BFS if the cell has fish
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public static int bfs(int[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col]; // To track visited cells
        queue.add(new Pair(i, j, grid[i][j]));
        visited[i][j] = true;
        int totalFish = 0;

        // BFS directions (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int x = curr.i;
            int y = curr.j;
            totalFish += grid[x][y]; // Add the fish in the current cell

            for (int[] d : directions) {
                int newX = x + d[0];
                int newY = y + d[1];

                // Check if the neighbor is valid, not visited, and contains fish
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] > 0 && !visited[newX][newY]) {
                    queue.add(new Pair(newX, newY, grid[newX][newY]));
                    visited[newX][newY] = true; // Mark the cell as visited
                }
            }
        }
        return totalFish; // Return the total fish collected
    }
}

class Pair {
    int i, j;
    int fish;

    Pair(int i, int j, int fish) {
        this.i = i;
        this.j = j;
        this.fish = fish;
    }
}
