class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        return getFunc(rowIndex,0,list);
    }
    public static List<Integer> getFunc(int rowIndex, int i, ArrayList<Integer> list){
        if(i==rowIndex) return list;
        ArrayList<Integer> arr=new ArrayList<>();
        int n=list.size();
        arr.add(1);
        for(int k=0;k<n-1;k++) arr.add(list.get(k)+list.get(k+1));
        arr.add(1);
        return getFunc(rowIndex,i+1,arr);

    }
}