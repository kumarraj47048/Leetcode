class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n=nums.length;
        long ct=0;
        int curr=0;
        int p1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                curr++;
                if(curr==1){
                    p1=i;
                }
                ct=(ct+i-p1+1);
            }else{
                curr=0;
                p1=i;
            }
        }
        return ct;
    }
}