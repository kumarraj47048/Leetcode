class Solution {
    int rowX[]={-1,0,1,0};
    int colY[]={0,1,0,-1};
    public int minimumEffortPath(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;
        int dis[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        dis[0][0]=0;
        PriorityQueue<Tuple> q=new PriorityQueue<>((a,b)->(a.distance-b.distance));
        q.add(new Tuple(0,0,0));
        while(q.size()>0){
            Tuple curr=q.poll();
            int currDis=curr.distance;
            int currRow=curr.row;
            int currCol=curr.col;

            for(int i=0;i<4;i++){
                int newX=currRow+rowX[i];
                int newY=currCol+colY[i];
                if(newX>=0 && newY>=0 && newX<row && newY<col){
                int newDis=Math.max(Math.abs(heights[newX][newY]- heights[currRow][currCol]),currDis);
                if(newDis<dis[newX][newY]){
                    dis[newX][newY]=newDis;
                    q.add(new Tuple(newDis,newX,newY));
                }
                }
            }
        }
        return dis[row-1][col-1];
    }
}

class Tuple{
    int distance,row,col;
    Tuple(int distance,int row, int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}