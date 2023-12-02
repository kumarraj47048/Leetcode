class Solution {
    public String simplifyPath(String path) {
        String res="";
        Deque<String> st=new ArrayDeque<>();
        for(int i=0;i<path.length();++i){
            if(path.charAt(i)=='/') continue;
            String temp="";
            while(i<path.length() && path.charAt(i)!='/'){
                temp+=path.charAt(i);
                ++i;
            }
            
            if(temp.equals("..")){
                if(st.size()!=0) st.pop();
            }
            else if(temp.equals(".")) continue;
            else {
                st.push(temp);
               
            }
        }

       // String res="";
        while(st.size()!=0){
            res="/"+st.pop()+res;
        }
        if(res.length()==0) return "/";
        return res;
    }
}