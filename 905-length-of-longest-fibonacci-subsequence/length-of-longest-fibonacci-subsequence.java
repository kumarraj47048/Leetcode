import java.util.HashMap;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];
                if (diff < arr[j] && dp[j].containsKey(diff)) { 
                    dp[i].put(arr[j], dp[j].get(diff) + 1);
                    maxLen = Math.max(maxLen, dp[i].get(arr[j]));
                } else {
                    dp[i].put(arr[j], 2);
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
