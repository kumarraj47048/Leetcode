class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) temp[i]=0;
            else temp[i]=1;
        }

        int ct=0;
        int sum=0;
        
        for(int i:temp){
            sum+=i;
            if(sum==k) ct++;
            if(hm.containsKey(sum-k)) ct+=hm.get(sum-k);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return ct;
    }
}