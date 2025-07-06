class FindSumPairs {
    HashMap<Integer,Integer> map;
    int arr1[];
    int arr2[];
    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1=nums1;
        arr2=nums2;
        map=new HashMap<>();
        for(int j=0;j<arr2.length;j++){
            map.put(arr2[j],map.getOrDefault(arr2[j],0)+1);
        }
    }
    
    public void add(int index, int val) {
        int prev_value=arr2[index];
        int new_value=arr2[index]+val;
        arr2[index]+=val;
        map.put(prev_value,map.getOrDefault(prev_value,0)-1);
        if(map.get(prev_value)<=0) map.remove(prev_value);

        map.put(new_value,map.getOrDefault(new_value,0)+1);
    }
    
    public int count(int tot) {
        int ct=0;
        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(tot-arr1[i])) ct+=map.get(tot-arr1[i]);
        }
        return ct;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */