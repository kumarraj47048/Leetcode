class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length;
        int col = isWater[0].length;
        int height[][] = new int[row][col];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                height[i][j]=Integer.MAX_VALUE;
                if(isWater[i][j]==1){
                    q.add(new Pair(i,j,0));
                    height[i][j]=0;
                }
            }
        }

        while(q.size()>0){
            Pair curr=q.poll();
            int x=curr.i;
            int y=curr.j;
            int val=curr.val;
            if(x-1>=0){
                if(height[x-1][y]>val+1){
                    height[x-1][y]=val+1;
                    q.add(new Pair(x-1,y,val+1));
                }
            }


            if(x+1<row){
                if(height[x+1][y]>val+1){
                    height[x+1][y]=val+1;
                    q.add(new Pair(x+1,y,val+1));
                }
            }


            if(y-1>=0){
                if(height[x][y-1]>val+1){
                    height[x][y-1]=val+1;
                    q.add(new Pair(x,y-1,val+1));
                }
            }


            if(y+1<col){
                if(height[x][y+1]>val+1){
                    height[x][y+1]=val+1;
                    q.add(new Pair(x,y+1,val+1));
                }
            }
        }
        return height;
    }
}

class Pair {
    int i, j;
    int val;

    Pair(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}