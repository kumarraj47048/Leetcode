class Solution {
    public int calculate(String s) {
        if(s==null || s.isEmpty()) return 0;
        int n=s.length();
        Deque<Integer> stack=new ArrayDeque<>();
        int currN=0;
        char op='+';
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                currN=currN*10 +(c-'0');
            }
            if(!Character.isDigit(c) && c!=' ' || i==n-1 ){
                if(op=='+'){
                    stack.push(currN);
                }
                else if(op=='-'){
                    stack.push(-currN);
                }
                else if(op=='*'){
                    stack.push(stack.pop()*currN);
                }
                else if(op=='/'){
                    stack.push(stack.pop()/currN);
                }
                currN=0;
                op=c;
            }
        }
        int res=0;
        while(stack.size()!=0) res+=stack.pop();
        return res;
        
    }
}