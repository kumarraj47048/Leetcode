class Solution {
    public int minimumObstacles(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
       // Queue<Pair> q=new LinkedList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.Val - b.Val);
        int dis[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dis[i][j]=row*col+1;
            }
        }
        if(grid[0][0]==1){
            q.add(new Pair(0,0,1));
            dis[0][0]=1;
        }
        else{
            q.add(new Pair(0,0,0));
            dis[0][0]=0;
        }
        
        while(q.size()>0){
            Pair curr=q.poll();
            int currx=curr.x;
            int curry=curr.y;
            int currVal=curr.Val;
            
            if(currx-1>=0 && grid[currx-1][curry]==1 && dis[currx-1][curry]>currVal+1){
                dis[currx-1][curry]=currVal+1;
                q.add(new Pair(currx-1,curry,currVal+1));
            }
            else if(currx-1>=0 && grid[currx-1][curry]==0 && dis[currx-1][curry]>currVal){
                dis[currx-1][curry]=currVal;
                q.add(new Pair(currx-1,curry,currVal));
            }
            
            
            
             if(currx+1<row && grid[currx+1][curry]==1 && dis[currx+1][curry]>currVal+1){
                dis[currx+1][curry]=currVal+1;
                q.add(new Pair(currx+1,curry,currVal+1));
            }
            else if(currx+1<row && grid[currx+1][curry]==0 && dis[currx+1][curry]>currVal){
                dis[currx+1][curry]=currVal;
                q.add(new Pair(currx+1,curry,currVal));
            }
            
            
            
             if(curry-1>=0 && grid[currx][curry-1]==1 && dis[currx][curry-1]>currVal+1){
                dis[currx][curry-1]=currVal+1;
                q.add(new Pair(currx,curry-1,currVal+1));
            }
            else if(curry-1>=0 && grid[currx][curry-1]==0 && dis[currx][curry-1]>currVal){
                dis[currx][curry-1]=currVal;
                q.add(new Pair(currx,curry-1,currVal));
            }
            
            
             if(curry+1<col && grid[currx][curry+1]==1 && dis[currx][curry+1]>currVal+1){
                dis[currx][curry+1]=currVal+1;
                q.add(new Pair(currx,curry+1,currVal+1));
            }
            else if(curry+1<col && grid[currx][curry+1]==0 && dis[currx][curry+1]>currVal){
                dis[currx][curry+1]=currVal;
                q.add(new Pair(currx,curry+1,currVal));
            }
        }
        return dis[row-1][col-1];
    }
}
class Pair{
    int x;
    int y;
    int Val;
    Pair(int x, int y, int Val){
        this.x=x;
        this.y=y;
        this.Val=Val;
    }
}