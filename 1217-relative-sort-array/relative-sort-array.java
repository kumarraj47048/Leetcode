class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max=Arrays.stream(arr1).max().orElse(0);
        int ct[]=new int[max+1];

        for(int i:arr1) ct[i]++;

        List<Integer> res=new ArrayList<>();
        for(int val:arr2){
            while(ct[val]>0){
                res.add(val);
                ct[val]--;
            }
        }

        for(int i=0;i<=max;i++){
            while(ct[i]>0){
                res.add(i);
                ct[i]--;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}