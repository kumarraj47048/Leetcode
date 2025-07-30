class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c==')' && st.size()>0 && st.peek()=='(') st.pop();
            else if(c=='}' && st.size()>0 && st.peek()=='{') st.pop();
            else if(c==']' && st.size()>0 && st.peek()=='[') st.pop();
            else if(c=='(' || c=='{' || c=='[') st.push(c);
            else return false;
        }
        return st.size()==0;
    }
}