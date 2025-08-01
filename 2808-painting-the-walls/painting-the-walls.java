class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        Integer[][] dp = new Integer[n + 1][n + 1];
        return dfs(0, n, cost, time, dp);
    }

    private int dfs(int i, int wallsLeft, int[] cost, int[] time, Integer[][] dp) {
        if (wallsLeft <= 0) return 0;
        if (i == cost.length) return Integer.MAX_VALUE / 2; // avoid overflow

        if (dp[i][wallsLeft] != null) return dp[i][wallsLeft];

        // Option 1: Paint current wall yourself -> reduce wallsLeft by 1 + time[i]
        int pick = cost[i] + dfs(i + 1, Math.max(0, wallsLeft - 1 - time[i]), cost, time, dp);

        // Option 2: Skip current wall
        int skip = dfs(i + 1, wallsLeft, cost, time, dp);

        return dp[i][wallsLeft] = Math.min(pick, skip);
    }
}
