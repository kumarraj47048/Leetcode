class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        int dp[][]=new int[n+2][n+2];
        for(int i[]:dp) Arrays.fill(i,0);

        //base case for length 1
        for(int i=1;i<=n;i++){
            dp[i][i]=arr[i-1]*arr[i]*arr[i+1];
        }

        //base case for length 2
        // for(int i=1;i<=n-1;i++){
        //     int sum=0;
        //     sum=Math.max(sum,arr[i-1]*arr[i]*arr[i+2]+ arr[i]*arr[i+1]*arr[i+2]);
        //     sum=Math.max(sum,arr[i-1]*arr[i+1]*arr[i+2]+ arr[i-1]*arr[i]*arr[i+1]);
        //     dp[i][i+1]=sum;
        // }

        int length=2;
        while(length<=n){
            int st=1;
            int end=length+st-1;
            while(end<=n){
                int p1=st;
               // int sum=0;
                while(p1<=end){
                    dp[st][end]=Math.max(dp[st][end],dp[st][p1-1]+dp[p1+1][end]+arr[st-1]*arr[p1]*arr[end+1]);
                    p1++;
                }
               // dp[st][end]=sum;
                st++;
                end++;
            }
            length++;
        }
    
    return dp[1][n];

    }
}