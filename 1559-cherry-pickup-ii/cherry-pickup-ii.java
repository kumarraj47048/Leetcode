class Solution {
    public HashMap<String,Integer> map=new HashMap<>();
    public int cherryPickup(int[][] grid) {
        return solve(0,0,0,grid[0].length-1,grid);
    }
    public int solve(int r1, int c1, int r2, int c2, int grid[][]){
        int row=grid.length;
        int col=grid[0].length;
        if(r1>=row) return 0;
        

        String key=r1+","+c1+","+r2+","+c2;
        if(map.containsKey(key)) return map.get(key);
        int sum=0;
        if(c1==c2) sum+=grid[r1][c1];
        else sum+=grid[r1][c1]+grid[r2][c2];
        
        int max=0;
        //left down
        if(c1-1>=0){
            if(c2-1>=0) max=Math.max(max,solve(r1+1,c1-1,r2+1,c2-1,grid));
                        max=Math.max(max,solve(r1+1,c1-1,r2+1,c2,grid));
            if(c2+1<col) max=Math.max(max,solve(r1+1,c1-1,r2+1,c2+1,grid));
        }
       

       //down
          if(c2-1>=0)
          max=Math.max(max,solve(r1+1,c1,r2+1,c2-1,grid));
          max=Math.max(max,solve(r1+1,c1,r2+1,c2,grid));
          if(c2+1<col)
          max=Math.max(max,solve(r1+1,c1,r2+1,c2+1,grid));

       
       // right down

       if(c1+1<col){
            if(c2-1>=0) max=Math.max(max,solve(r1+1,c1+1,r2+1,c2-1,grid));
                        max=Math.max(max,solve(r1+1,c1+1,r2+1,c2,grid));
            if(c2+1<col) max=Math.max(max,solve(r1+1,c1+1,r2+1,c2+1,grid));
        }
      
      map.put(key,sum+max);
      return sum+max;
        

    }
}