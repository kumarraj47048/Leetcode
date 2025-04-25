class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int ct=0;
        int n=nums.size();
        Collections.sort(nums);
        int p1=0,p2=n-1;
        while(p1<p2){
            while(p1<p2 && nums.get(p1)+nums.get(p2)>=target) p2--;
            ct+=p2-p1;
            p1++;
        }
        return ct;
    }
}