class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> p=new PriorityQueue<>();
        int ct=0;
        for(int i:nums) p.add((long)i);
        while(p.size()>=2){
            if(p.peek()>=k) return ct;
            ct++;
            long x=p.poll()*2 +p.poll();    
            p.add(x);
        }
        return ct;
    }
}