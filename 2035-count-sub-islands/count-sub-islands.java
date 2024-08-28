class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ct=0;
        int row=grid1.length;
        int col=grid1[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid2[i][j]==1 && grid1[i][j]==1 && bfs(grid1,grid2,i,j)==1){
                    ct++;
                   
                }
                if(grid2[i][j]==1)
                func(grid1,grid2,i,j);
            }
        }
       
    return ct;
    }
    public static int bfs(int grid1[][], int grid2[][], int i, int j){
        int row=grid1.length;
        int col=grid1[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean vis[][]=new boolean[row][col];
        q.add(new Pair(i,j));
        vis[i][j]=true;
        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            if(x-1>=0 && vis[x-1][y]==false && grid2[x-1][y]==1){
                if(grid1[x-1][y]==0) return 0;
                else{
                    q.add(new Pair(x-1,y));
                    vis[x-1][y]=true;
                }
            }
            if(x+1<row && vis[x+1][y]==false && grid2[x+1][y]==1){
                if(grid1[x+1][y]==0) return 0;
                else{
                    q.add(new Pair(x+1,y));
                    vis[x+1][y]=true;
                }
            }
            if(y-1>=0 && vis[x][y-1]==false && grid2[x][y-1]==1){
                if(grid1[x][y-1]==0) return 0;
                else{
                    q.add(new Pair(x,y-1));
                    vis[x][y-1]=true;
                }
            }
            if(y+1<col && vis[x][y+1]==false && grid2[x][y+1]==1){
                if(grid1[x][y+1]==0) return 0;
                else{
                    q.add(new Pair(x,y+1));
                    vis[x][y+1]=true;
                }
            }
        }
        return 1;
    }

    public static void func(int grid1[][], int grid2[][], int i, int j){
         int row=grid1.length;
        int col=grid1[0].length;
        Queue<Pair> q=new LinkedList<>();
       // boolean vis[][]=new boolean[row][col];
        q.add(new Pair(i,j));
        //vis[i][j]=true;
        grid2[i][j]=0;
        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            if(x-1>=0 && grid2[x-1][y]==1){
                    q.add(new Pair(x-1,y));
                    grid2[x-1][y]=0;
            }
            if(x+1<row && grid2[x+1][y]==1){
                
                    q.add(new Pair(x+1,y));
                    grid2[x+1][y]=0;
                
            }
            if(y-1>=0 && grid2[x][y-1]==1){
                
                    q.add(new Pair(x,y-1));
                    grid2[x][y-1]=0;
                
            }
            if(y+1<col && grid2[x][y+1]==1){
               
                    q.add(new Pair(x,y+1));
                    grid2[x][y+1]=0;
                
            }
        }
    }
}
class Pair{
    int x,y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}