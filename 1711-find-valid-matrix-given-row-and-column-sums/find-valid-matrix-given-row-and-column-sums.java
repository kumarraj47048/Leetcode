class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row=rowSum.length;
        int col=colSum.length;
        int ans[][]=new int[row][col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                ans[i][j]=Math.min(rowSum[i],colSum[j]);
                rowSum[i]-=ans[i][j];
                colSum[j]-=ans[i][j];
            }
        }
        return ans;
    }
}