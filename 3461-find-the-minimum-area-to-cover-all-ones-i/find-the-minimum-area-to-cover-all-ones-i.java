class Solution {
    public int minimumArea(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        int left=0;
        int right=0;
        int up=0;
        int down=0;
        for(int j=0;j<col;j++){
            boolean found=false;
            for(int i=0;i<row;i++){
                if(grid[i][j]==1){
                    found=true;
                    left=j;
                    break;
                }
            }
            if(found) break;
        }

        //right

         for(int j=col-1;j>=0;j--){
            boolean found=false;
            for(int i=0;i<row;i++){
                if(grid[i][j]==1){
                    found=true;
                    right=j;
                    break;
                }
            }
            if(found) break;
        }


        //up
        for(int i=0;i<row;i++){
            boolean found=false;
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    up=i;
                    found=true;
                    break;
                }
            }
            if(found) break;
        }

        //down
        for(int i=row-1;i>=0;i--){
            boolean found=false;
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    found=true;
                    down=i;
                    break;
                }
            }
            if(found) break;
        }
       

       return (down-up+1)*(right-left+1);

    }
}