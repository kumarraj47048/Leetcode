class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Deque<Integer> st=new ArrayDeque<>();
        int ns[]=new int[m];
        ns[m-1]=-1;
        st.push(nums2[m-1]);
        for(int i=m-2;i>=0;i--){
            while(st.size()!=0 && nums2[i]>=st.peek()) st.pop();
            if(st.size()==0) ns[i]=-1;
            else ns[i]=st.peek();
            st.push(nums2[i]);
        }

        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int t=nums1[i];
            for(int j=0;j<m;j++){
                if(t==nums2[j]){
                    ans[i]=ns[j];
                    break;
                }
            }
        }
        return ans;
    }
}