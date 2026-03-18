class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int row=grid.length;
        int col=grid[0].length;
        int ct=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i>0 && j>0) grid[i][j]+=grid[i-1][j]+grid[i][j-1]-grid[i-1][j-1]; 
                else if(i==0 && j==0);
                else if(i==0) grid[i][j]+=grid[i][j-1];
                else if(j==0) grid[i][j]+=grid[i-1][j];

                if(grid[i][j]<=k) ct++;

               // System.out.print(grid[i][j]+" ");
            }
           // System.out.println();
        }

        return ct;

    }
}