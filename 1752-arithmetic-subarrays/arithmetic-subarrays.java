class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> list=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=l[i];j<=r[i];j++) arr.add(nums[j]);
            list.add(func(arr));
        }
        return list;
    }

    public static boolean func(ArrayList<Integer> arr){
       // Collections.sort(arr);
        int n=arr.size();
        int max=arr.get(0);
        int min=arr.get(0);
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            max=Math.max(max,arr.get(i));
            min=Math.min(min,arr.get(i));
            set.add(arr.get(i));
        }

        int diff=(max-min)/(n-1);
        if((max-min)%(n-1)!=0) return false;
        int curr=min;
        while(curr!=max){
            if(!set.contains(curr+diff)) return false;
            curr=curr+diff;
        }
        return true;
    }
}