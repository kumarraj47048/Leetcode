class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int ct[][]=new int[n][2];
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            ct[u][0]=u;
            ct[u][1]++;
            ct[v][0]=v;
            ct[v][1]++;
        }
        Arrays.sort(ct,(a,b)->b[1]-a[1]);
        long sum=0;
        for(int i=0;i<ct.length;i++){
            sum+=(long)((long)ct[i][1]*(long)n);
            n--;
        }
        return sum;
    }
}