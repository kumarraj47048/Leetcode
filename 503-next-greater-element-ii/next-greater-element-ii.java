class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Deque<Integer> st=new ArrayDeque<>();
        int idx=0;
        int ns[]=new int[n];
        // while(nums[(n-1)%n]>nums[idx%n]){
        //     idx++;
        // }
        // if(idx==n-1){
        //     ns[n-1]=-1;
        // }
        // else stack.push(nums[idx]);
        for(int i=n-2;i>=0;i--){
            st.push(nums[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(st.size()!=0 && nums[i]>=st.peek()) st.pop();
            if(st.size()==0) ns[i]=-1;
            else ns[i]=st.peek();
            st.push(nums[i]);
        }
        return ns;
    }
}