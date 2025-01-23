class Solution {
    public int countServers(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 || grid[i][j]==5){
                    func(i,j,grid);
                }
            }
        }

        int ct=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==5) ct++;
            }
        }
        return ct;
    }
    public static void func(int x, int y, int grid[][]){
        int row=grid.length;
        int col=grid[0].length;
        int ct=0;
        for(int i=0;i<row;i++){
            if(i!=x && grid[i][y]==1){
                ct++;
                grid[i][y]=5;
            }
        }

        for(int i=0;i<col;i++){
            if(i!=y && grid[x][i]==1){
                ct++;
                grid[x][i]=5;
            }
        }
        if(ct>0) grid[x][y]=5;
    }
}