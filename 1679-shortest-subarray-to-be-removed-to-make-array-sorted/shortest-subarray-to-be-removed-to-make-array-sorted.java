class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        int low=0;
        int high=n-2;
        boolean pf[]=new boolean[n];
        boolean sf[]=new boolean[n];
        pf[0]=true;
        for(int i=1;i<n;i++){
            if(pf[i-1]==false) pf[i]=false;
            else if(arr[i]<arr[i-1]) pf[i]=false;
            else pf[i]=true;
        }
        sf[n-1]=true;
        for(int i=n-2;i>=0;i--){
            if(sf[i+1]==false) sf[i]=false;
            else if(arr[i]>arr[i+1]) sf[i]=false;
            else sf[i]=true;
        }
        int ans=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(check(arr,mid,pf,sf)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        for(int i=0;i<n;i++){
            System.out.print(pf[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(sf[i]+" ");
        }
     return ans;
    }
    public static boolean check(int nums[], int sz, boolean pf[], boolean sf[]){
        int n=nums.length;
        if(pf[n-sz-1]==true || sf[sz]==true) return true;
        int first=nums[0];
        int last=nums[sz+1];
        if(first<=last && pf[0]==true && sf[sz+0+1]==true) return true;
        for(int i=1;i<=n-sz-2;i++){
            first=nums[i];
            last=nums[i+sz+1];
            if(first<=last && pf[i]==true && sf[i+sz+1]==true) return true;
        }
        return false;
    }
}