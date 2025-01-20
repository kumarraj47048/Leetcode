class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n=arr.length;
        int row=mat.length;
        int col=mat[0].length;
        HashMap<Integer,Pair> map=new HashMap<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                map.put(mat[i][j],new Pair(i,j));
            }
        }
        for(int i=0;i<n;i++){
            if(check(arr[i],mat,map)) return i;
        }


        return -1;
    }
    public static boolean check(int val, int mat[][], HashMap<Integer,Pair> map){
        int row=mat.length;
        int col=mat[0].length;
        Pair curr=map.get(val);
        int x=curr.x;
        int y=curr.y;
        mat[x][y]=0;
        boolean check=false;
        for(int i=0;i<row;i++){
            if(mat[i][y]!=0) break;
            else if(mat[i][y]==0 && i==row-1) check=true;
        }

        for(int j=0;j<col;j++){
            if(mat[x][j]!=0) break;
            else if(mat[x][j]==0 && j==col-1) check=true;
        }
        return check;
    }
}
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}