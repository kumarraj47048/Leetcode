class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[]=new int[n];
        int ct=0;
        for(int i[]:edges){
            indegree[i[1]]++;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                ct++;
                if(ct>=2) return -1;
                ans=i;
            }
        }
        return ans;
    }
}