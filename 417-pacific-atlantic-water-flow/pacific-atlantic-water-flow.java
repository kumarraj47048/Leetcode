class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(bfs(heights,i,j)){
                    List<Integer> inList=new ArrayList<>();
                    inList.add(i);
                    inList.add(j);
                    list.add(inList);
                }
            }
        }
        return list;
    }

    public static boolean bfs(int[][] heights, int i, int j){
        int row=heights.length;
        int col=heights[0].length;
        int vis[][]=new int[row][col];
        boolean p=false,a=false;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=1;
        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            if(x==0) p=true;
            if(x==row-1) a=true;
            if(y==0) p=true;
            if(y==col-1) a=true; 
            int val=heights[x][y];
            if(x-1>=0 && vis[x-1][y]==0 && val>=heights[x-1][y]){
                q.add(new Pair(x-1,y));
                vis[x-1][y]=1;
                if(x-1==0) p=true;
                if(p==true && a==true) return true;
            }

             if(y-1>=0 && vis[x][y-1]==0 && val>=heights[x][y-1]){
                q.add(new Pair(x,y-1));
                vis[x][y-1]=1;
                if(y-1==0) p=true;
                if(p==true && a==true) return true;
            }

             if(x+1<row && vis[x+1][y]==0 && val>=heights[x+1][y]){
                q.add(new Pair(x+1,y));
                vis[x+1][y]=1;
                if(x+1==row-1) a=true;
                if(p==true && a==true) return true;
            }

             if(y+1<col && vis[x][y+1]==0 && val>=heights[x][y+1]){
                q.add(new Pair(x,y+1));
                vis[x][y+1]=1;
                if(y+1==col-1) a=true;
                if(p==true && a==true) return true;
            }

        }
    if(a==true && p==true) return true;
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