class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int sum=0;
        int dp[]=new int[row];
        
        for(int i=0;i<row;i++){
            dp[i]=triangle.get(row-1).get(i);
        }
        int col=0;
        for(int i=row-2;i>=0;i--){
            
            for(int j=0;j<=i;j++){
                dp[j]=triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
            }
           
        }
        return dp[0];
        
    }
}