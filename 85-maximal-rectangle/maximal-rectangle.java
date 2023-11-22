class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans=0;
        int row=matrix.length;
        int col=matrix[0].length;
        int temp[]=new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1') temp[j]++;
                else temp[j]=0;
            }
            ans=Math.max(ans, getMaxH(temp));
        }
        return ans;
    }

    public static int getMaxH(int arr[]){
        int max=0;
        int n=arr.length;
        Deque<Integer> st=new ArrayDeque<>();
        int ps[]=new int[n];
        int ns[]=new int[n];
        for(int i=0;i<n;i++){
            while(st.size()!=0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) ps[i]=-1;
            else             ps[i]=st.peek();
            st.push(i);
        }
        while(st.size()!=0) st.pop();

        for(int i=n-1;i>=0;i--){
            while(st.size()!=0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) ns[i]=n;
            else             ns[i]=st.peek();
            st.push(i);
        }

        for(int i=0;i<n;i++){
            max=Math.max(max, arr[i]*(ns[i]-ps[i]-1));
        }
        return max;
    }
}