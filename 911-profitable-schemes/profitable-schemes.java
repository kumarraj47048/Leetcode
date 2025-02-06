import java.util.Arrays;

class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[group.length][n + 1][minProfit + 1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, 0, n, minProfit, group, profit, dp);
    }

    private int solve(int idx, int people, int val_profit, int n, int minProfit, int[] group, int[] profit, int[][][] dp) {
        int mod = 1000000007;

        if (idx == group.length) {
            return val_profit >= minProfit ? 1 : 0;  // Valid scheme
        }

        if (dp[idx][people][val_profit] != -1) {
            return dp[idx][people][val_profit];  // Memoized result
        }

        // Option 1: Don't take the current crime
        int ans = solve(idx + 1, people, val_profit, n, minProfit, group, profit, dp);

        // Option 2: Take the current crime if people limit allows
        if (people + group[idx] <= n) {
            ans = (ans + solve(idx + 1, people + group[idx], Math.min(minProfit, val_profit + profit[idx]), 
                               n, minProfit, group, profit, dp)) % mod;
        }

        return dp[idx][people][val_profit] = ans;
    }
}
