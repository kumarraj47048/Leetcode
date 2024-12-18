class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        Stack<Integer> st=new Stack<>();
        int ns[]=new int[n];
        ns[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && prices[st.peek()]>prices[i]) st.pop();
            if(st.size()==0) ns[i]=n;
            else ns[i]=st.peek();
            st.push(i);
        }
        
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=prices[i];
            if(ns[i]<n){
                ans[i]-=prices[ns[i]];
            }
        }
        return ans;
    }
}