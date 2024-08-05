class Solution {
    public String kthDistinct(String[] arr, int k) {
        int n=arr.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<String> list=new ArrayList<>();
        for(String i:arr){
            if(map.get(i)==1){
                list.add(i);
            }
            if(list.size()==k) return i;
        }
        return "";
    }
}