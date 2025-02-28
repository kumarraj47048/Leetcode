class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        
        // Step 1: Compute LCS using Bottom-Up DP
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Step 2: Construct SCS using LCS table
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--; j--;  // Move diagonally
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;  // Move up
            } else {
                sb.append(str2.charAt(j - 1));
                j--;  // Move left
            }
        }
        
        // Add remaining characters
        while (i > 0) sb.append(str1.charAt(--i));
        while (j > 0) sb.append(str2.charAt(--j));
        
        return sb.reverse().toString();
    }
}
