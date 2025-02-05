class Solution {
    public int ways(String[] pizza, int k) {
        int mod=1000000007;
        int row=pizza.length;
        int col=pizza[0].length();
        int arr[][]=new int[row+1][col+1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pizza[i].charAt(j)=='A') arr[i+1][j+1]=1;
            }
        }
       // int dp[][][]=new int[row+1][col+1][k+1];
       int hor[][]=new int[row+1][col+1];
      // int x=0;
       if(arr[row][col]==1) hor[row][col]=1;
       for(int j=col-1;j>=0;j--){
          hor[row][j]=hor[row][j+1];
          if(arr[row][j]==1) hor[row][j]++;
       }
       for(int j=row-1;j>=0;j--){
          hor[j][col]=hor[j+1][col];
          if(arr[j][col]==1) hor[j][col]++;
       }
       
       for(int i=row-1;i>=0;i--){
          
          for(int j=col-1;j>=0;j--){
              hor[i][j]=hor[i][j+1];
              int x_temp=0;
              for(int m=i;m<=row;m++){
                if(arr[m][j]==1) x_temp++;
              }
              hor[i][j]+=x_temp;
          }
       }
       int dp[][][]=new int[row+1][col+1][k+1];
       for(int i=0;i<=row;i++){
        for(int j=0;j<=col;j++){
            for(int m=0;m<=k;m++){
                dp[i][j][m]=-1;
            }
        }
       }
       int ans=solve(1,1,hor,k,dp);

       return ans;

       

    //    for(int i=0;i<=row;i++){
    //     for(int j=0;j<=col;j++){
    //         System.out.print(hor[i][j]+" ");
    //     }
    //     System.out.println();
    //    }
       //int ans=solve(0,0)
        
    }
    
    public static int solve(int i, int j, int hor[][], int k, int dp[][][]){
        int row=hor.length-1;
        int col=hor[0].length-1;
        if(hor[i][j]<k) return 0;
        int mod=1000000007;
        if(k==1){
            if(hor[i][j]>=1) return 1;
            return 0;
        }
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        //if(i>row || j>col) return 1;
        int ans=0;
       
        
        for(int h=i+1;h<=row;h++){
            int down=hor[h][j];
            int up=hor[i][j]-down;
            if(up>=1 && down>=k-1) ans=(ans+solve(h,j,hor,k-1,dp))%mod;
        }
        for(int h=j+1;h<=col;h++){
            int right=hor[i][h];
            int left=hor[i][j]-right;
            if(left>=1 && right>=k-1) ans=(ans+solve(i,h,hor,k-1,dp))%mod;
        }
        return dp[i][j][k]=ans;
    }
}
    