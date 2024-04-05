class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.size()>0 && Math.abs(ch-st.peek())=='a'-'A') st.pop();
            else st.push(ch);
        }
        StringBuilder sb=new StringBuilder("");
        while(st.size()>0){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}