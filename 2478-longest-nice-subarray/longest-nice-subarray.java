class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n=nums.length;
        int ans=1;
        int low=1,high=n;
        int pf[][]=new int[n][32];
        for(int i=0;i<32;i++){
            if(((nums[0]>>i)&1)==1) pf[0][i]=1;
        }

        for(int i=0;i<32;i++){
            for(int j=1;j<n;j++){
                pf[j][i]=pf[j-1][i];
                if(((nums[j]>>i)&1)==1) pf[j][i]++;
               // System.out.print(pf[j][i]+" ");
            }
           // System.out.println();
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<32;j++){
        //         System.out.print(pf[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        
        while(low<=high){
            int mid=(low+high)/2;
            if(func(nums,mid,pf)){
                ans=mid;
                low=mid+1;
            }else high=mid-1;
        }
        // for(int i=1;i<=n;i++){
        //     if(func(nums,i)) ans=i;
        // }
        return ans;
    }
    public static boolean func(int nums[], int k, int pf[][]){
        int n=nums.length;
        for(int i=k-1;i<n;i++){
            boolean check=true;
            for(int m=0;m<32;m++){
                int ct=0;
                if(i==k-1) ct=pf[i][m];
                else ct=pf[i][m]-pf[i-k][m];
                if(ct>1) check=false;
            }
            if(check) return true;
        }
        return false;
    }
}