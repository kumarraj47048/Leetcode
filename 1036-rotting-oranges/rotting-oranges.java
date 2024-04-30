class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int row=grid.length;
        int col=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    grid[i][j]=0;
                }
            }
        }
        
        int t=0;
        int size=q.size();
        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            if(x-1>=0 && grid[x-1][y]==1){
                q.add(new Pair(x-1,y));
                grid[x-1][y]=0;
            }
            if(y-1>=0 && grid[x][y-1]==1){
                q.add(new Pair(x,y-1));
                grid[x][y-1]=0;
            }
            if(x+1<row && grid[x+1][y]==1){
                q.add(new Pair(x+1,y));
                grid[x+1][y]=0;
            }
            if(y+1<col && grid[x][y+1]==1){
                q.add(new Pair(x,y+1));
                grid[x][y+1]=0;
            }
            size--;
            if(size==0){
                size=q.size();
                t++;
            }
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
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}