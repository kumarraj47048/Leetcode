class Solution {
    public int maxChunksToSorted(int[] arr) {
       int n=arr.length;
       int end=0;
       int start=0;
       int ct=0;
       while(start<n){
            end=idxFind(start,arr);
            start++;
            while(end<n && start<=end){
                int tempIdx=idxFind(start,arr);
                if(tempIdx<n && tempIdx>end) end=tempIdx;
                start++;
            }
           ct++;
       }
       return ct; 
    }
    public static int idxFind(int idx, int arr[]){
        int n=arr.length;
        for(int i=n-1;i>idx;i--){
            if(arr[idx]>arr[i]) return i;
        }
        return n;
    }
}
