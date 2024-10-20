class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        char ch[]=expression.toCharArray();
        for(char c:ch){
            if(c==')'){
                ArrayList<Character> list=new ArrayList<>();
                while(st.peek()!='('){
                    list.add(st.pop());
                }
                st.pop();
                char op=st.pop();
                st.push(func(op,list));
            }
            else if(c!=',') st.push(c);
        }
        return st.peek()=='t';
    }
    public static char func(char op, ArrayList<Character> list){
        if(op=='!'){
            if(list.get(0)=='t') return 'f';
            else return 't';
        }
        else if(op=='&'){
            for(char c:list){
                if(c=='f') return 'f';
            }
            return 't';
        }
        else if(op=='|'){
            for(char c:list){
                if(c=='t') return 't';
            }
            return 'f';
        }
        return 'f';
    }
}