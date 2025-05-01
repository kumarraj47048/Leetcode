class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<k;i++) sum+=arr[i];
        int ct=0;
        if(sum/k>=threshold) ct++;
        for(int i=k;i<n;i++){
            sum+=arr[i];
            sum-=arr[i-k];
            if(sum/k>=threshold) ct++;
        }
        return ct;
    }
}