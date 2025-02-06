import java.util.*;

class Solution {
    public int numWays(String[] words, String target) {
        int len = words[0].length();
        int mod = 1000000007;
        int n = target.length();

        // Step 1: Build frequency HashMaps for each column
        HashMap<Character, Integer>[] freq = new HashMap[len];
        for (int i = 0; i < len; i++) {
            freq[i] = new HashMap<>();
            for (String word : words) {
                char ch = word.charAt(i);
                freq[i].put(ch, freq[i].getOrDefault(ch, 0) + 1);
            }
        }

        // Step 2: Initialize DP table
        int[][] dp = new int[len][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Step 3: Solve with Memoization
        return solve(0, 0, target.toCharArray(), dp, freq, mod);
    }

    private int solve(int idx, int i, char[] target, int[][] dp, HashMap<Character, Integer>[] freq, int mod) {
        if (i == target.length) return 1; // Target fully formed
        if (idx == freq.length) return 0; // Out of columns

        if (dp[idx][i] != -1) return dp[idx][i];

        int ans = solve(idx + 1, i, target, dp, freq, mod); // Skip current column

        char targetChar = target[i];
        if (freq[idx].containsKey(targetChar)) { // If the char exists in this column
            ans = (int)((ans + (1L * freq[idx].get(targetChar) * solve(idx + 1, i + 1, target, dp, freq, mod)) % mod) % mod);
        }

        return dp[idx][i] = ans;
    }
}
