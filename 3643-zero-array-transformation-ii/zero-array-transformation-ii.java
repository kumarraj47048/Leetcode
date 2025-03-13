class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;
        boolean check=false;
        for(int i:nums){
            if(i>0) check=true;
        }
        if(check==false) return 0;

        // for(int i=0;i<q;i++){
        //     int pf[]=new int[n];
        //     for(int j=0;j<n;j++) pf[j]=nums[j];
        //     if(func(pf,queries,i)) return i+1;
        //     System.out.println();
        // }


        int ans=q+1;
        int low=0;
        int high=q-1;
        while(low<=high){
            int mid=(low+high)/2;
            int pf[]=new int[n];
            for(int j=0;j<n;j++) pf[j]=nums[j];
            if(func(pf,queries,mid)){
                ans=mid+1;
                high=mid-1;
            }
            else low=mid+1;
        }
        if(ans==q+1)
        return -1;
        return ans;
    }
    public static boolean func(int pf[], int queries[][],int k){
        int n=pf.length;
        int diff[]=new int[n];

        for(int i=0;i<=k;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int val=queries[i][2];
            diff[start]-=val;
            if(end+1<pf.length) diff[end+1]+=val;
        }
        pf[0]+=diff[0];
        System.out.print(pf[0]+" ");
        for(int i=1;i<pf.length;i++){
            diff[i]+=diff[i-1];
            // System.out.print(pf[i]+" ");
            pf[i]+=diff[i]; 
            //System.out.print(pf[i]+" ");
        }
        for(int i:pf){
            if(i>0) return false;
        }
        
    return true;
    }
}