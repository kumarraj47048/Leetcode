class Solution {
    int rowX[]={-1,0,1,0};
    int colY[]={0,1,0,-1};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int lastDay=1;
        int left=1;
        int right=row*col;
        while(left<=right){
            int mid=(left+right)/2;
            if(isFound(mid,row,col,cells)){
                left=mid+1;
                lastDay=mid;
            }
            else right=mid-1;
        }
        return lastDay;
    }
    boolean isFound(int t,int row, int col, int cells[][]){
        int grid[][]=new int[row+1][col+1];
        for(int i=0;i<t;i++){
            grid[cells[i][0]][cells[i][1]]=1;
        }
        Queue<Pair> q=new LinkedList<>();
        int vis[][]=new int[row+1][col+1];

        for(int j=1;j<=col;j++){
            if(grid[1][j]==0){
                q.add(new Pair(1,j));
                vis[1][j]=1;
            }
        }

        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            for(int i=0;i<4;i++){
                int newX=x+rowX[i];
                int newY=y+colY[i];

                if(newX>0 && newY>0 && newX<=row && newX<=row && newY<=col && grid[newX][newY]==0 && vis[newX][newY]==0){
                    q.add(new Pair(newX,newY));
                    vis[newX][newY]=1;
                    if(newX==row) return true;
                }
            }

        }
        return false;
    }
}
class Pair{
    int x,y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}