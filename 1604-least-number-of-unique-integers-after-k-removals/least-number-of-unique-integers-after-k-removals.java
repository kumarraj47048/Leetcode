class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a: arr)
        {
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int help[]=new int[map.size()];
        int idx=0;
        for(int i: map.values()) 
            help[idx++]=i;
        Arrays.sort(help);
        int ct=0;
        for(int i=0;i<map.size();i++){
            if(k>help[i]){
                k-=help[i];
                help[i]=0;
            }
            else{
                help[i]-=k;
                k=0;
            }
            if(help[i]!=0) ct++;
        }
        return ct;
    }
}