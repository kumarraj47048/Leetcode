class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[]=new int[k];
        int ct[][]=new int[20001][2];
        for(int i:nums){
            ct[i+10000][0]++;
            ct[i+10000][1]=i;
        }
        Arrays.sort(ct,(a,b)->(b[0]-a[0]));
        for(int i=0;i<k;i++){
            ans[i]=ct[i][1];
        }
        return ans;
    }
}