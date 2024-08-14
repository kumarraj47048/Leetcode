class Solution {
    public long maximumStrength(int[] nums, int k) {
        int n = nums.length;
        long[][] dp = new long[k + 1][n + 1];

        for (int i = 1; i <= k; ++i) {
            long maxsum = (long)-1e15;
            long curr = (long)-1e15;
            long multiplier = (i % 2 == 1) ? (k + 1 - i) : (i - 1 - k);

            for (int j = i - 1; j < n; ++j) {
                curr = Math.max(curr + (long)nums[j] * multiplier, 
                                dp[i - 1][j] + (long)nums[j] * multiplier);
                
                maxsum = Math.max(maxsum, curr);
                dp[i][j + 1] = maxsum;
            }
        }

        return dp[k][n];
    }
}
