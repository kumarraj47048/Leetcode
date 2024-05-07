class Solution {
    int rowX[]=new int[]{-1,-1,0,1,1,1,0,-1};
    int colY[]=new int[]{0,1,1,1,0,-1,-1,-1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        if(grid[0][0]==1) return -1;
       
        int lvl[][]=new int[row][col];
        int vis[][]=new int[row][col];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        vis[0][0]=1;
        lvl[0][0]=1;
        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            if(x==row-1 && y==col-1) return lvl[x][y];
            for(int i=0;i<8;i++){
                int tempX=rowX[i]+x;
                int tempY=colY[i]+y;
                if((tempX>=0 && tempX<row && tempY>=0 && tempY<col) && (vis[tempX][tempY]==0 ) && (grid[tempX][tempY]==0)){
                    q.add(new Pair(tempX,tempY));
                    vis[tempX][tempY]=1;
                    lvl[tempX][tempY]=lvl[x][y]+1;
                    if(tempX==row-1 && tempY==col-1) return lvl[tempX][tempY];
                }
            }
        }
        
        return -1;
    }
}
class Pair{
    int x,y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}