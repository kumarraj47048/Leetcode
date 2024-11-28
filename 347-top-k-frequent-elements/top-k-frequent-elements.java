class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[]=new int[k];
        int ct[][]=new int[20001][2];
        for(int i:nums){
            ct[i+10000][0]++;
            ct[i+10000][1]=i;
        }
        PriorityQueue<int[]> p=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int i=0;i<=20000;i++){
            p.add(new int[]{ct[i][0],i-10000});
            if(p.size()>k) p.poll();
        }
        //Arrays.sort(ct,(a,b)->(b[0]-a[0]));
        for(int i=0;i<k;i++){
            ans[i]=p.poll()[1];
        }
        return ans;
    }
}