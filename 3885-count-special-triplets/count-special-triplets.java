class Solution {
    public int specialTriplets(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int mod=(int)1e9+7;
        for(int i=n-1;i>=0;i--){
            int x=nums[i];
            map.put(x,map.getOrDefault(x,0)+1);
        }

        int ct=0;
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int i=0;i<n;i++){
            int x=nums[i];
            
            map.put(x,map.getOrDefault(x,0)-1);

            int left=map.getOrDefault(x*2,0);
            int right=map2.getOrDefault(x*2,0);
            
            long y=((long)left*right)%mod;
            
            //if(i>0 && i<n-1)
            ct=(ct+(int)y)%mod;

          //  map.put(x,map.get(x)-1);
            map2.put(x,map2.getOrDefault(x,0)+1);
            
        }


        return ct;
    }
}