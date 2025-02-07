class Solution {
    public long findScore(int[] nums) {
        long ans=0;
        int n=nums.length;
        int sort[][]=new int[n][2];
        boolean mark[]=new boolean[n];
        for(int i=0;i<n;i++){
            sort[i][0]=nums[i];
            sort[i][1]=i;
        }

        Arrays.sort(sort,(a,b)->(a[0]-b[0]));
        for(int i=0;i<n;i++){
            int val=sort[i][0];
            int idx=sort[i][1];
            if(mark[idx]==false){
                ans+=val;
                mark[idx]=true;
            
            if(idx-1>=0){
                mark[idx-1]=true;
            }
            if(idx+1<n){
                mark[idx+1]=true;
            }
            }
        }
    return ans;
    }
}