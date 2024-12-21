import java.util.ArrayList;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        for (int[] edge : edges) {
            list[edge[1]].add(edge[0]);
            list[edge[0]].add(edge[1]);
        }
        int[] dp = new int[n + 1];
        int[] ct = new int[1]; // Single-element array to hold the count
        dfs(list, 0, dp, values, -1, k, ct);
        return ct[0] + 1; // Include the root itself as a valid component
    }

    private void dfs(ArrayList<Integer>[] list, int root, int[] dp, int[] values, int parent, int k, int[] ct) {
        dp[root] = values[root] % k; // Take modulo of the current node's value
        for (int neighbor : list[root]) {
            if (neighbor != parent) {
                dfs(list, neighbor, dp, values, root, k, ct);
                if (dp[neighbor] == 0) {
                    ct[0]++; // Increment count if child subtree forms a valid component
                } else {
                    dp[root] = (dp[root] + dp[neighbor]) % k; // Aggregate with modulo
                }
            }
        }
    }
}
