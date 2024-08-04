class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int pf[]=new int[n];
        pf[0]=nums[0];
        for(int i=1;i<n;i++){
            pf[i]=nums[i]+pf[i-1];
        }
        int arr[]=new int[n*(n+1)/2];
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i>0){
                    arr[idx++]=pf[j]-pf[i-1];
                }
                else arr[idx++]=pf[j];
            }
        }
        
        Arrays.sort(arr);
        int mod=1000000007;
        int cp[]=new int[n*(n+1)/2];
        cp[0]=arr[0];
        System.out.print(0+" : "+cp[0]+", ");
        for(int i=1;i<arr.length;i++){
            cp[i]=(cp[i-1]+arr[i])%mod;
            //System.out.print(i+" : "+cp[i]+", ");
        }
        left--;
        right--;
        if(left>0)
        return cp[right]-cp[left-1];
        else return cp[right];
    }
}