class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int arr[]=new int[52];
        for(int i=0;i<ranges.length;i++){
            int l=ranges[i][0];
            int r=ranges[i][1];
            arr[l]=arr[l]+1;
            arr[r+1]=arr[r+1]-1;
        }
        
        for(int i=1;i<52;i++){
            arr[i]=arr[i-1]+arr[i];
        }
        for(int i=left;i<=right;i++){
            if(arr[i]<=0) return false;
        }
        return true;
    }
}