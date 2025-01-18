class Solution {
    public int minCost(int[][] arr) {
        int row=arr.length;
        int col=arr[0].length;
        int dp[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j]=100000;
            }
        }
        dp[0][0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.add(new Pair(0,0,0));
        while(pq.size()>0){
            Pair curr=pq.poll();
            int x=curr.i;
            int y=curr.j;
            int currCost=curr.cost;
            if(x-1>=0){
                if(arr[x][y]!=4){
                    if(dp[x-1][y]>currCost+1){
                        dp[x-1][y]=currCost+1;
                        pq.add(new Pair(x-1,y,dp[x-1][y]));
                    }
                }
                else{
                    if(dp[x-1][y]>currCost){
                        dp[x-1][y]=currCost;
                        pq.add(new Pair(x-1,y,dp[x-1][y]));
                    }
                }
            }


            if(x+1<row){
                if(arr[x][y]!=3){
                    if(dp[x+1][y]>currCost+1){
                        dp[x+1][y]=currCost+1;
                        pq.add(new Pair(x+1,y,dp[x+1][y]));
                    }
                }
                else{
                    if(dp[x+1][y]>currCost){
                        dp[x+1][y]=currCost;
                        pq.add(new Pair(x+1,y,dp[x+1][y]));
                    }
                }
            }




            if(y-1>=0){
                if(arr[x][y]!=2){
                    if(dp[x][y-1]>currCost+1){
                        dp[x][y-1]=currCost+1;
                        pq.add(new Pair(x,y-1,dp[x][y-1]));
                    }
                }
                else{
                    if(dp[x][y-1]>currCost){
                        dp[x][y-1]=currCost;
                        pq.add(new Pair(x,y-1,dp[x][y-1]));
                    }
                }
            }


            if(y+1<col){
                if(arr[x][y]!=1){
                    if(dp[x][y+1]>currCost+1){
                        dp[x][y+1]=currCost+1;
                        pq.add(new Pair(x,y+1,dp[x][y+1]));
                    }
                }
                else{
                    if(dp[x][y+1]>currCost){
                        dp[x][y+1]=currCost;
                        pq.add(new Pair(x,y+1,dp[x][y+1]));
                    }
                }
            }
        }
        return dp[row-1][col-1];
    }
}
class Pair{
    int i,j;
    int cost;
    Pair(int i, int j, int cost){
        this.i=i;
        this.j=j;
        this.cost=cost;
    }
}