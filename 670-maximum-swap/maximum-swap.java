class Solution {
    public int maximumSwap(int num) {
        int dp[]=new int[9];
        int idx=8;
        while(num>0){
            dp[idx--]=num%10;
            num/=10;
        }
        idx++;
        boolean check=false;
        for(int i=idx;i<8;i++){
            int x=dp[i];
            int y=dp[i+1];
            int idxTemp=i+1;
            for(int j=i+2;j<9;j++){
                if(y<=dp[j]){
                    y=dp[j];
                    idxTemp=j;
                }
            }
            if(x<y && check==false){
                    int temp=dp[i];
                    dp[i]=dp[idxTemp];
                    dp[idxTemp]=temp;
                    check=true;
                }
        }
        int ans=0;
        int ten=1;
        for(int i=8;i>=0;i--){
            ans=ten*dp[i]+ans;
            ten*=10;
        }
      //  for(int i:dp) System.out.print(i+" ");
        return ans;
    }
}