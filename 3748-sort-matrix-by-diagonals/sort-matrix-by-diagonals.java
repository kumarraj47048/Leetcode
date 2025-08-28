class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        for(int k=0;k<n;k++){
            int j=0;
            int i=k;
            ArrayList<Integer> list=new ArrayList<>();
            while(j<n && i<n){
                list.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(list,Collections.reverseOrder());
            j=0;
            i=k;
            while(j<n && i<n){
                grid[i][j]=list.get(j);
                i++;
                j++;
            }
        }



        for(int k=1;k<n;k++){
            int i=0;
            int j=k;
            ArrayList<Integer> list=new ArrayList<>();
            while(j<n && i<n){
                list.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(list);
            j=k;
            i=0;
            while(j<n && i<n){
                grid[i][j]=list.get(i);
                i++;
                j++;
            }
        }

        return grid;
    }
}