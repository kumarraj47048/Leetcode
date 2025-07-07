class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++) list.add(new ArrayList<>());

        list.get(0).add(1);
        for(int i=1;i<numRows;i++){
            list.get(i).add(1);
            int prev_size=list.get(i-1).size();
            prev_size--;
            for(int j=0;j<prev_size;j++){
                int val=list.get(i-1).get(j)+ list.get(i-1).get(j+1);
                list.get(i).add(val);
            }
            list.get(i).add(1);
        }
        return list;
    }
}