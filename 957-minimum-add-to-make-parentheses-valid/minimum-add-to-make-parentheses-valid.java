class Solution {
    public int minAddToMakeValid(String s) {
        char ch[]=s.toCharArray();
        Stack<Character> st=new Stack<>();
        st.push(ch[0]);
        for(int i=1;i<ch.length;i++){
            if(ch[i]=='(') st.push(ch[i]);
            else if(st.size()>0 && ch[i]==')' && st.peek()=='(') st.pop();
            else st.push(ch[i]);
        }
        return st.size();
    }
}