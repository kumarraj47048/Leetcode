class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans=0;
        int mod=1000000007;
        int dp[]=new int[high+1];
        Arrays.fill(dp,-1);
       // rec(high,one,zero,dp);
        for(int i=low;i<=high;i++){
            ans=(ans+rec(i,one,zero,dp))%mod;
        }
        return ans%mod;
    }
    public int rec(int length,int one, int zero,int dp[]){
        int mod=1000000007;
        if(length<0) return 0;
        if(length==0) return 1;
        if(dp[length]!=-1) return dp[length]%mod;
        return dp[length]=(rec(length-one,one,zero,dp)+rec(length-zero,one,zero,dp))%mod;
    }
}