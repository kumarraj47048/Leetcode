class Solution {
    public int evalRPN(String[] tokens) {
      //  int ans=0;
        Deque<Integer> st=new ArrayDeque<>();
        // int first=Integer.valueOf(tokens[0]);
        // int second=Integer.valueOf(tokens[1]);
        // st.push(first);
        // st.push(second);
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
              int y=  st.pop();
                int x=st.pop();
                st.push(x+y);
            }
            else if(tokens[i].equals("-")){
              int y=  st.pop();
                int x=st.pop();
                st.push(x-y);
            }
            else if(tokens[i].equals("*")){
              int y=  st.pop();
                int x=st.pop();
                st.push(x*y);
            }
            else if(tokens[i].equals("/")){
              int y=  st.pop();
                int x=st.pop();
                st.push(x/y);
            }
            else{
                 st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.peek();
    }
}