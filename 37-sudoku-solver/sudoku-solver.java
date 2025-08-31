class Solution {
    public static int check=0;
    public void solveSudoku(char[][] board) {
       solve(board,0,0); 
       check=0;
    }

    public static void solve(char board[][],int row, int col){
      if(row==9){
       check=1;
       return;
      }

      else if(board[row][col]!='.'){
           if(col!=8)  solve(board,row,col+1);
           else        solve(board,row+1,0);
       }

       else {

           for(char ch='1';ch<='9';ch++){
               if(isValid(board,row,col,ch)){
                   board[row][col]=ch;
                  if(col!=8)
                  solve(board,row,col+1);
                  else
                  solve(board,row+1,0);
                  if(check==1)  return;
                  board[row][col]='.';
               }
           }
       }
    }

    public static boolean isValid(char board[][], int row, int col, char num){
        // checking row

        for(int i=0;i<9;i++){
            if(board[row][i]==num)
            return false;
        }

        //checking col

        for(int i=0;i<9;i++){
            if(board[i][col]==num)
            return false;
        }


        //checking subSquare

        int startRow=row/3*3;
        int startCol=col/3*3;

        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j]==num)
                return false;
            }
        }

        return true;
    }
}