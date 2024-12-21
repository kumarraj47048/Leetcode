class Solution {
    //public static int ct=0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<Integer> list[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++) list[i]=new ArrayList<>();
        for(int i=0;i<n;i++) values[i]%=k;
        for(int i[]:edges){
              list[i[1]].add(i[0]);
              list[i[0]].add(i[1]);
        }
        int dp[]=new int[n+1];
        int ct[]=new int[1];
       dfs(list,0,dp,values,-1,k,ct);
       return ct[0]+1;
    }

    public static void dfs(ArrayList<Integer> list[],int root, int dp[], int values[],int parent,int k,int ct[]){

        for(int u:list[root]){
            if(u!=parent) dfs(list,u,dp,values,root,k,ct);
        }
        dp[root]=values[root];
        for(int u:list[root]){
            if(u!=parent){
                if(dp[u]%k==0) ct[0]++;
                else dp[root]+=dp[u];
            }
        }
       // System.out.println(dp[root]);
    }
}