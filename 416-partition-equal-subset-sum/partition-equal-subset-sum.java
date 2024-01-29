class Solution {
   static Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;

        dp=new Boolean[nums.length+1][sum+1];
       int tar=sum/2;
       return func(tar,nums,0); 
    }
    
    public static boolean func(int tar,int nums[],int idx){
        if(tar<0 || idx>=nums.length) return false;
        if(tar==0) return true;
        if(dp[idx][tar]!=null) return dp[idx][tar];
        return dp[idx][tar]=(func(tar-nums[idx],nums,idx+1) || func(tar,nums,idx+1));
    }
}