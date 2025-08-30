class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]!='.'){
                    if(!check(i,j,board)) return false;
                }
            }
        }

        return true;
    }
    public boolean check(int r, int c, char board[][]){
        char ch=board[r][c];
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            if(board[i][c]==ch && i!=r) return false;
        }

        for(int j=0;j<col;j++){
            if(board[r][j]==ch && j!=c) return false;
        }

        int boxR=(r/3)*3;
        int boxC=(c/3)*3;

        for(int i=boxR;i<=boxR+2;i++){
            for(int j=boxC;j<=boxC+2;j++){
                if(i!=r && j!=c && board[i][j]==ch) return false;
            }
        }

        return true;
    }
}