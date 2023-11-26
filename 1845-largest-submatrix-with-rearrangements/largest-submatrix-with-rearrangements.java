class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]!=0 && i>0){
                  matrix[i][j]+=matrix[i-1][j];
                }
            }

            int currRow[]=matrix[i].clone();
            Arrays.sort(currRow);
            for(int k=0;k<col;k++){
                ans=Math.max(ans, currRow[k]*(col-k));
            }
        }
      return ans;
    }
}