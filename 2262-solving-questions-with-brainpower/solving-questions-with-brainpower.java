import java.util.*;

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n + 1]; // Extra space for easier boundary handling
        
        for (int i = n - 1; i >= 0; i--) {
            long skip = dp[i + 1]; // If we skip this question
            long not_skip = questions[i][0]; // If we take this question
            
            int nextIndex = i + questions[i][1] + 1;
            if (nextIndex < n) {
                not_skip += dp[nextIndex];
            }
            
            dp[i] = Math.max(skip, not_skip);
        }
        
        return dp[0];
    }
}
