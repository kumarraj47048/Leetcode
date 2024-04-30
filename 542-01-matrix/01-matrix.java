class Solution {
    public int[][] updateMatrix(int[][] grid) {
      int row=grid.length;
        int col=grid[0].length;
        int ans[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                ans[i][j]=row+col+1;
            }
        }
        
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    ans[i][j]=0;
                    q.add(new Pair(i,j));
                }
            }
        }
        
        
        int size=q.size();
        int currD=1;
        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            
            if(x-1>=0 && ans[x-1][y]>currD){
                q.add(new Pair(x-1,y));
                ans[x-1][y]=currD;
            }
            if(y-1>=0 && ans[x][y-1]>currD){
                q.add(new Pair(x,y-1));
                ans[x][y-1]=currD;
            }
            if(x+1<row && ans[x+1][y]>currD){
                q.add(new Pair(x+1,y));
                ans[x+1][y]=currD;
            }
            if(y+1<col && ans[x][y+1]>currD){
                q.add(new Pair(x,y+1));
                ans[x][y+1]=currD;
            }
            
            size--;
            if(size==0){
                currD++;
                size=q.size();
            }
        }
        return ans;
    }
}
class Pair{
    int x,y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}