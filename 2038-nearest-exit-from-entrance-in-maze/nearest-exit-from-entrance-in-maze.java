class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row=maze.length;
        int col=maze[0].length;
        int ct=0;
        Queue<Pair> q=new LinkedList<>();
        int rowA=entrance[0];
        int colA=entrance[1];
        boolean vis[][]=new boolean[row][col];
        int lvl[][]=new int[row][col];
        q.add(new Pair(rowA,colA));
        vis[rowA][colA]=true;
        lvl[rowA][colA]=0;
        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            
            if(x-1>=0 && vis[x-1][y]==false  && maze[x-1][y]=='.'){
                if(x-1==0 || y==0 || y==col-1){
                   lvl[x-1][y]=lvl[x][y]+1;
                   vis[x-1][y]=true;
                   return lvl[x-1][y];
                }
                else{
                   lvl[x-1][y]=lvl[x][y]+1;
                   vis[x-1][y]=true;
                   q.add(new Pair(x-1,y));
                }
            }

             if(y-1>=0 && vis[x][y-1]==false  && maze[x][y-1]=='.'){
                if(y-1==0 || x==0 || x==row-1){
                   lvl[x][y-1]=lvl[x][y]+1;
                   vis[x][y-1]=true;
                   return lvl[x][y-1];
                }
                else{
                   lvl[x][y-1]=lvl[x][y]+1;
                   vis[x][y-1]=true;
                   q.add(new Pair(x,y-1));
                }
            }


             if(x+1<row && vis[x+1][y]==false  && maze[x+1][y]=='.'){
                if(x+1==row-1  || y==0 || y==col-1){
                   lvl[x+1][y]=lvl[x][y]+1;
                   vis[x+1][y]=true;
                   return lvl[x+1][y];
                }
                else{
                   lvl[x+1][y]=lvl[x][y]+1;
                   vis[x+1][y]=true;
                   q.add(new Pair(x+1,y));
                }
            }



             if(y+1<col && vis[x][y+1]==false  && maze[x][y+1]=='.'){
                if(y+1==col-1 || x==0 || x==row-1){
                   lvl[x][y+1]=lvl[x][y]+1;
                   vis[x][y+1]=true;
                   return lvl[x][y+1];
                }
                else{
                   lvl[x][y+1]=lvl[x][y]+1;
                   vis[x][y+1]=true;
                   q.add(new Pair(x,y+1));
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