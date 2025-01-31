import java.util.*;

class Solution {
    int[] rowX = {-1, 0, 1, 0};
    int[] colY = {0, 1, 0, -1};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int max = 0;
        int group = 2; // Start from 2 to avoid confusion with 1s and 0s
        int[][] dem = new int[n][n];
        Map<Integer, Integer> islandSize = new HashMap<>();

        // Step 1: Label each island with a unique group ID and compute sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = bfs(grid, i, j, group, dem);
                    islandSize.put(group, size);
                    max = Math.max(max, size);
                    group++;
                }
            }
        }

        // Step 2: Try flipping each 0 and calculate the maximum possible island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int len = 1;
                    Set<Integer> visitedGroups = new HashSet<>();
                    
                    for (int k = 0; k < 4; k++) {
                        int newX = i + rowX[k];
                        int newY = j + colY[k];

                        if (newX >= 0 && newY >= 0 && newX < n && newY < n) {
                            int groupID = dem[newX][newY];
                            if (groupID > 0 && !visitedGroups.contains(groupID)) {
                                len += islandSize.get(groupID);
                                visitedGroups.add(groupID);
                            }
                        }
                    }
                    max = Math.max(max, len);
                }
            }
        }

        return max;
    }

    private int bfs(int[][] grid, int i, int j, int group, int[][] dem) {
        int n = grid.length;
        int size = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = group;
        dem[i][j] = group;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            size++;

            for (int k = 0; k < 4; k++) {
                int newX = x + rowX[k];
                int newY = y + colY[k];

                if (newX >= 0 && newY >= 0 && newX < n && newY < n && grid[newX][newY] == 1) {
                    grid[newX][newY] = group;
                    dem[newX][newY] = group;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return size;
    }
}
