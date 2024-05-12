class Solution {
    int rowX[]=new int[]{-1,-1,0,1,1,1,0,-1};
    int colY[]=new int[]{0,1,1,1,0,-1,-1,-1};
    public int[][] largestLocal(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int ans[][]=new int[row-2][col-2];
        for(int i=1;i<row-1;i++){
            for(int j=1;j<col-1;j++){
                for(int k=0;k<8;k++){
                    int newX=i+rowX[k];
                    int newY=j+colY[k];
                    ans[i-1][j-1]=Math.max(ans[i-1][j-1], grid[newX][newY]);
                }
                ans[i-1][j-1]=Math.max(ans[i-1][j-1],grid[i][j]);
              
            }
        }
        return ans;
    }
}