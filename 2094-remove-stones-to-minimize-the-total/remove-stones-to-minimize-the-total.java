class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:piles) pq.add(i);
        while(k-->0){
            if(pq.size()<=0) break;
            int x=pq.poll();
            pq.add(x-(x/2));
        }
        int sum=0;
        while(pq.size()>0){
            sum+=pq.poll();
        }
        return sum;
    }
}