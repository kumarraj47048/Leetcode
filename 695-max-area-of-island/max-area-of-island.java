class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                max=Math.max(max,bfs(grid,i,j));
            }
        }
        return max;
    }
    public int bfs(int grid[][],int i, int j){
        int ct=0;
        int row=grid.length;
        int col=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        grid[i][j]=0;
        ct++;
        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            if(x-1>=0 && grid[x-1][y]==1){
                q.add(new Pair(x-1,y));
                grid[x-1][y]=0;
                ct++;
            }
              if(x+1<row && grid[x+1][y]==1){
                q.add(new Pair(x+1,y));
                grid[x+1][y]=0;
                ct++;
            }
              if(y-1>=0 && grid[x][y-1]==1){
                q.add(new Pair(x,y-1));
                grid[x][y-1]=0;
                ct++;
            }
              if(y+1<col && grid[x][y+1]==1){
                q.add(new Pair(x,y+1));
                grid[x][y+1]=0;
                ct++;
            }

        }
        return ct;
    }
}
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}