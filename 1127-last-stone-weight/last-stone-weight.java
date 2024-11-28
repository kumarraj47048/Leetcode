class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p=new PriorityQueue<>(Collections.reverseOrder());
        if(p.size()==1) return p.poll();
        for(int i:stones) p.add(i);
        while(p.size()>1){
            int a=p.poll();
            int b=p.poll();
            if(a!=b) p.add(a-b);
        }
        if(p.size()==1) return p.poll();
        return 0;
    }
}