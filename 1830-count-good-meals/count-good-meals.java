class Solution {
    public int countPairs(int[] val) {
        int n=val.length;
        int mod=1000000007;
        int ct=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int pow[]=new int[22];
        pow[0]=1;
        for(int i=1;i<=21;i++) pow[i]=2*pow[i-1];
        for(int i=0;i<n;i++){
            for(int k=0;k<=21;k++){
                int temp=pow[k]-val[i];
                if(map.containsKey(temp)){
                    ct=(ct+map.get(temp))%mod;
                }
            }
            map.put(val[i],map.getOrDefault(val[i],0)+1);
        }
        return ct;
    }

}