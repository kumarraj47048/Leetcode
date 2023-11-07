class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
       double arrTime[]=new double[n];
        for(int i=0;i<n;i++) arrTime[i]=(double)dist[i]/speed[i];
        Arrays.sort(arrTime);
        int ans=1;
        for(int i=1;i<n;i++){
            if(arrTime[i]>i) ans++;
            else return ans;
        }
        return ans;
    }
}