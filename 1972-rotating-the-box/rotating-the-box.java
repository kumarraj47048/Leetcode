class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int row=boxGrid[0].length;
        int col=boxGrid.length;
        char ans[][]=new char[row][col];
        for(int i=0;i<col;i++){
            int p1=row-1;
            int p2=row-1;
            while(p2>=0){
                if(boxGrid[i][p2]=='.'){
                    p2--;
                }
                else if(boxGrid[i][p2]=='*'){
                    ans[p2][col-i-1]='*';
                    while(p1>p2){
                        ans[p1][col-i-1]='.';
                        p1--;
                    }
                    p2--;
                    p1=p2;
                }
                else{
                    ans[p1][col-i-1]='#';
                    p2--;
                    p1--;
                }
            }
            while(p1>=0){
                ans[p1][col-i-1]='.';
                p1--;
            }
        }   
        return ans;
    }
}