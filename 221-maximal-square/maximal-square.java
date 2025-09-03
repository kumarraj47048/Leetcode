class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    public int maximalSquare(char[][] matrix) {
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                
                if(matrix[i][j]=='1') max=Math.max(max,solve(i,j,matrix));
            }
        }
        return max*max;
    }
    public int solve(int r, int c, char matrix[][]){
        int row=matrix.length;
        int col=matrix[0].length;
        String key=r+","+c;
        if(map.containsKey(key)) return map.get(key);
        if(r>=row || c>=col) return 0;
        if(matrix[r][c]=='0') return 0;

        int right=0;
        if(c+1<col){
            right=solve(r,c+1,matrix);
        }
        int diag=0;
        if(r+1<row && c+1<col){
            diag=solve(r+1,c+1,matrix);
        }
        int down=0;
        if(r+1<row){
            down=solve(r+1,c,matrix);
        }

        int val=1+Math.min(right,Math.min(diag,down));
        map.put(key,val);
        return val;

    }
}