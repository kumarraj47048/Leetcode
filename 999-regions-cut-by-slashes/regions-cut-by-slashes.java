class Solution {
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        int arr[][]=new int[n*3][n*3];
         for (int i = 0; i < n; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                int uRow = i * 3;
                int lCol = j * 3;
                if (s.charAt(j) == '/') {
                    arr[uRow][lCol + 2] = 1;
                    arr[uRow + 1][lCol + 1] = 1;
                    arr[uRow + 2][lCol] = 1;
                } else if (s.charAt(j) == '\\') {
                    arr[uRow][lCol] = 1;
                    arr[uRow + 1][lCol + 1] = 1;
                    arr[uRow + 2][lCol + 2] = 1;
                }
            }
        }
        int ct=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n*3;i++){
            for(int j=0;j<n*3;j++){
                if(arr[i][j]==0){
                    q.add(new Pair(i,j));
                    arr[i][j]=1;
                    ct++;
                    while(q.size()>0){
                        Pair curr=q.poll();
                        int x=curr.x;
                        int y=curr.y;

                        if(x-1>=0 && arr[x-1][y]==0){
                            q.add(new Pair(x-1,y));
                            arr[x-1][y]=1;
                        }
                        if(x+1<n*3 && arr[x+1][y]==0){
                            q.add(new Pair(x+1,y));
                            arr[x+1][y]=1;
                        }

                        if(y-1>=0 && arr[x][y-1]==0){
                            q.add(new Pair(x,y-1));
                            arr[x][y-1]=1;
                        }

                        if(y+1<n*3 && arr[x][y+1]==0){
                            q.add(new Pair(x,y+1));
                            arr[x][y+1]=1;
                        }
                    }
                }
            }
        }

       
        return ct;
    }
}
class Pair{
    int x,y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}