import java.util.HashMap;
import java.util.Map;

class Solution {
    private final int[][] directions = {
        {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };
    private Map<String, Double> memo; // Memoization map

    public double knightProbability(int n, int k, int row, int column) {
        memo = new HashMap<>();
        return dp(n, k, row, column);
    }

    private double dp(int n, int k, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n) return 0.0; // Out of bounds → 0 probability
        if (k == 0) return 1.0; // No moves left → probability 1
        String key = row + "," + col + "," + k;
        if (memo.containsKey(key)) return memo.get(key); // Use memoized result
        
        double probability = 0.0;
        for (int[] dir : directions) {
            probability += dp(n, k - 1, row + dir[0], col + dir[1]) / 8.0;
        }
        
        memo.put(key, probability);
        return probability;
    }
}
