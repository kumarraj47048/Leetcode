class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int t=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        while(q.size()>0){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int curr[]=q.poll();
                int x=curr[0];
                int y=curr[1];

                if(x-1>=0 && grid[x-1][y]==1){
                   grid[x-1][y]=2;
                   q.add(new int[]{x-1,y});
                }
                if(x+1<row && grid[x+1][y]==1){
                   grid[x+1][y]=2;
                   q.add(new int[]{x+1,y});
                }
                if(y-1>=0 && grid[x][y-1]==1){
                   grid[x][y-1]=2;
                   q.add(new int[]{x,y-1});
                }
                if(y+1<col && grid[x][y+1]==1){
                   grid[x][y+1]=2;
                   q.add(new int[]{x,y+1});
                }
 
            }
            t++;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        if(t==0) return t;
        return t-1;
    }
}