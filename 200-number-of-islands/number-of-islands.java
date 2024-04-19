class Solution {
    public int numIslands(char[][] grid) {
        int ct=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ct++;
                    bfs(grid,i,j);
                }
            }
        }
        return ct;
    }
    public void bfs(char[][] grid, int x, int y){
        Queue<int[]> q=new LinkedList<>();
        int ar[]=new int[]{x,y};
        q.add(ar);
        grid[x][y]='0';
        while(!q.isEmpty()){
            int i=q.peek()[0];
            int j=q.peek()[1];
            q.poll();
            if(i-1>=0 && grid[i-1][j]=='1'){
                q.add(new int[]{i-1,j});
                grid[i-1][j]='0';
            }
             if(j-1>=0 && grid[i][j-1]=='1'){
                q.add(new int[]{i,j-1});
                grid[i][j-1]='0';
            }
             if(i+1<grid.length && grid[i+1][j]=='1'){
                q.add(new int[]{i+1,j});
                grid[i+1][j]='0';
            }
             if(j+1<grid[0].length && grid[i][j+1]=='1'){
                q.add(new int[]{i,j+1});
                grid[i][j+1]='0';
            }
        }
    }
}