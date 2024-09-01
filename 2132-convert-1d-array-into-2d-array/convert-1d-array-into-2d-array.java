class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len=original.length;
         int arr[][]=new int[m][n];
        if(len!=m*n) return new int[0][0];
        int idx=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=original[idx++];
            }
        }
        return arr;
    }
}