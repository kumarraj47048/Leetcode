class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length()/k;
        if(s.length()%k>0) n++;
        String ans[]=new String[n];
        char ch[]=s.toCharArray();
        int idx=0;
        int part=0;
        while(idx<s.length()){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<k && idx<s.length();i++){
                sb.append(ch[idx]);
                idx++;
            }
            ans[part++]=sb.toString();
        }

        while(idx%k!=0){
            //if(part>n) return ans;
            ans[ans.length-1]+=fill;
            idx++;
        }
        return ans;
    }
}