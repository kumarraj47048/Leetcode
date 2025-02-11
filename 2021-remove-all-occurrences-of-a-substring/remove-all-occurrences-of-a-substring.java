class Solution {
    public String removeOccurrences(String s, String part) {
        char ch[]=s.toCharArray();
        char p[]=part.toCharArray();
        int n=p.length;
        Stack<Character> st=new Stack<>();
        for(char c:ch){
            st.push(c);
            if(c==p[n-1]){
                int idx=n-1;
                Stack<Character> temp=new Stack<>();
                while(st.size()>0 && idx>=0 && p[idx]==st.peek()){
                    temp.push(st.pop());
                    idx--;
                }
                if(idx>=0){
                    while(temp.size()>0) st.push(temp.pop());
                }
                else{
                    while(temp.size()>0) temp.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(st.size()>0){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}