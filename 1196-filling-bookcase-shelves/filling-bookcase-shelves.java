class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n=books.length;
        int nums[][]=new int[n+1][2];
        for(int i=1;i<=n;i++){
            nums[i][0]=books[i-1][0];
            nums[i][1]=books[i-1][1];
        }
        int dp[]=new int[n+1];
        dp[1]=nums[1][1];
        for(int i=2;i<=n;i++) dp[i]=Integer.MAX_VALUE;
        for(int i=2;i<=n;i++){
            int sum=nums[i][0];
            dp[i]=dp[i-1]+nums[i][1];
            int j=i-1;
            int max=nums[i][1];
            while(j>0 && sum<=shelfWidth){
                sum+=nums[j][0];
                max=Math.max(max,nums[j][1]);
                if(sum<=shelfWidth){
                    dp[i]=Math.min(dp[i],dp[j-1]+max);
                }
                j--;
            }
        }
        return dp[n];
    }
}