class Solution {
    public long continuousSubarrays(int[] nums) {
        long ct=0;
        int p1=0;
        int p2=0;
        int n=nums.length;

        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Comparator.reverseOrder());
    
        while(p2<n){
            int x=nums[p2];
            while(p1<p2 && (Math.abs(min.peek()-x)>2 || Math.abs(max.peek()-x)>2)){
                min.remove(nums[p1]);
                max.remove(nums[p1]);
                p1++;
            }
            ct+=p2-p1+1;
            min.add(x);
            max.add(x);
            p2++;
        }
    return ct;
    }
}