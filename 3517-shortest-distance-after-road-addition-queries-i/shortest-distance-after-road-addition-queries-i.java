class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=1;i<n;i++) graph[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            graph[i+1].add(i);
        }
        int ans[]=new int[queries.length];
        int idx=0;
        for(int i[]:queries){
            int st=i[0];
            int end=i[1];
            graph[end].add(st);
            ans[idx++]=topDown(graph);
        }
        return ans;
    }
    public static int topDown(ArrayList<Integer> graph[]){
       
       int n=graph.length;
        int dp[]=new int[n];
        Arrays.fill(dp,n);
        dp[0]=0;
        for(int i=1;i<n;i++){
            for(int u:graph[i]){
                dp[i]=Math.min(dp[i],dp[u]+1);
            }
        }
    return dp[n-1];
    }
}
