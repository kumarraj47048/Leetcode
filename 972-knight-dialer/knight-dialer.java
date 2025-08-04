class Solution {
    public static int dir[][]={{-2,-2,-1,1,2,2,1,-1},
                        {-1,1,2,2,1,-1,-2,-2}};
    public static int mod=1000000007;
    public int knightDialer(int n) {
        boolean arr[][]=new boolean[4][3];
        for(int i=0;i<4;i++) Arrays.fill(arr[i],true);
        arr[3][0]=false;
        arr[3][2]=false;
        int ct=0;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(arr[i][j]){
                    ct=(ct+solve(n,i,j,arr,map))%mod;
                }
            }
        }

        return ct;
    }

    public static int solve(int steps, int i, int j, boolean arr[][], HashMap<String,Integer> map){

        int ct=0;
        if(steps==1) return 1;
        String key=steps+","+i+","+j;
        if(map.containsKey(key)) return map.get(key);
        for(int m=0;m<8;m++){
            int new_row=i+dir[0][m];
            int new_col=j+dir[1][m];

            if(new_row>=0 && new_row<4 && new_col>=0 && new_col<3 && arr[new_row][new_col]){
                ct=(ct+solve(steps-1,new_row,new_col,arr,map))%mod;
            }
        }
        map.put(key,ct);
        return ct;
    }
}