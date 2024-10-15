class Solution {
    public long minimumSteps(String s) {
        long ans=0;
        char ch[]=s.toCharArray();
        int p1=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='0'){
                ans+=i-p1;
                p1++;
            }
        }
        return ans;
    }
}