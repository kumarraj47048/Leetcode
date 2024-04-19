class Solution {
    public void solve(char[][] board) {
       
        int row=board.length;
        int col=board[0].length;

         for(int i=0;i<row;i++){
            if(board[i][0]=='O') bfs(board,i,0);
         }
         for(int i=0;i<row;i++){
            if(board[i][col-1]=='O') bfs(board,i,col-1);
         }
          
         for(int j=0;j<col;j++){
            if(board[0][j]=='O') bfs(board,0,j);
         }
          for(int j=0;j<col;j++){
            if(board[row-1][j]=='O') bfs(board,row-1,j);
         }
       
      for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(board[i][j]=='1') board[i][j]='O';
            else if(board[i][j]=='O') board[i][j]='X';
        }
      }

    }

    public void bfs(char board[][], int i, int j){
        Queue<Pair> q=new LinkedList<>();
        int row=board.length;
        int col=board[0].length;
        board[i][j]='1';
        if(i-1>=0 && board[i-1][j]=='O'){
            board[i-1][j]='1';
            q.add(new Pair(i-1,j));
        }
         if(j-1>=0 && board[i][j-1]=='O'){
            board[i][j-1]='1';
            q.add(new Pair(i,j-1));
        }
        if(i+1<row && board[i+1][j]=='O'){
            board[i+1][j]='1';
            q.add(new Pair(i+1,j));
        }
        if(j+1<col && board[i][j+1]=='O'){
            board[i][j+1]='1';
            q.add(new Pair(i,j+1));
        }

        while(q.size()>0){
            Pair curr=q.poll();
            board[curr.x][curr.y]='1';
            int m=curr.x;
            int n=curr.y;
          if(m-1>=0 && board[m-1][n]=='O'){
            board[m-1][n]='1';
            q.add(new Pair(m-1,n));
        }
         if(n-1>=0 && board[m][n-1]=='O'){
            board[m][n-1]='1';
            q.add(new Pair(m,n-1));
        }
        if(m+1<row && board[m+1][n]=='O'){
            board[m+1][n]='1';
            q.add(new Pair(m+1,n));
        }
        if(n+1<col && board[m][n+1]=='O'){
            board[m][n+1]='1';
            q.add(new Pair(m,n+1));
        }

        }
    }
}

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}