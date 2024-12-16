class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n=nums.length;
        PriorityQueue<Pair> p=new PriorityQueue<>((a,b)->{
            if(a.val==b.val) return Integer.compare(a.idx,b.idx);
            else return Integer.compare(a.val,b.val);
        });
        for(int i=0;i<n;i++){
            p.add(new Pair(nums[i],i));
        }
        while(k-->0){
            Pair curr=p.poll();
            nums[curr.idx]*=multiplier;
            p.add(new Pair(nums[curr.idx],curr.idx));
        }
        return nums;
    }
}
class Pair{
    int val;
    int idx;
    Pair(int val, int idx){
        this.val=val;
        this.idx=idx;
    }
}