class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
       // PriorityQueue<Integer> list[]=new PriorityQueue<Integer>()[row];
       ArrayList<PriorityQueue<Integer>> list=new ArrayList<>();
        for(int i=0;i<row;i++){
            PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
            for(int j=0;j<col;j++){
                pq.add(grid[i][j]);
            }
            list.add(pq);
        }
        
        int res=0;
        int num=-1;
        for(int j=0;j<col;j++){
            num=-1;
            for(int i=0;i<row;i++){
                num=Math.max(num,list.get(i).poll());
            }
            res+=num;
        }
        return res;
    }
}