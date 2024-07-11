class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='(') st.push(sb.length());
            else if(c==')'){
                int start=st.pop();
                reverse(sb,start,sb.length()-1);
            }
            else sb.append(c);
        }
        return sb.toString();
    }
    void reverse(StringBuilder sb, int start, int end){
        while(start<end){
            char t=sb.charAt(start);
            sb.setCharAt(start++,sb.charAt(end));
            sb.setCharAt(end--,t);
        }
    }
}