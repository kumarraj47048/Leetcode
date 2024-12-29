class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int pf[] = new int[n + 2];
        int arr[] = new int[n + 2];
        for (int i = 0; i < n; i++)
            arr[i + 1] = nums[i];
        for (int i = n; i >= 1; i--)
            arr[i] = arr[i] + arr[i + 1];
        for (int i = n - 1; i >= 1; i--)
            if (i + k <= n + 1)
                pf[i] = arr[i] - arr[i + k];
        int dp[][][] = new int[n + 2][4][2];
        for (int i = n - 1; i >= 1; i--) {
            dp[i][3][0] = i;
            dp[i][3][1] = pf[i];
        }
        int t = 2;
        for (int l = 2; l >= 1; l--) {
            for (int i = n - (t * k) + 1; i >= 1; i--) {
                dp[i][l][0] = i;
                dp[i][l][1] = pf[i];
                for (int j = i + k; j <= n - k + 1; j++) {
                    if (dp[i][l][1] < dp[j][l + 1][1] + pf[i]) {
                        dp[i][l][1] = dp[j][l + 1][1] + pf[i];
                        dp[i][l][0] = j;
                    }
                }
            }
            t++;
        }

        int ans[] = new int[3];
        int max = 0;
        int idx = n + 1;
        for (int i = n; i >= 1; i--) {
            if (max <= dp[i][1][1]) {
                max = dp[i][1][1];
                idx = i;
            }
        }

        ans[0] = idx - 1;
        ans[1] = dp[idx][1][0] - 1;
        ans[2] = dp[ans[1] + 1][2][0] - 1;
        return ans;
    }
}