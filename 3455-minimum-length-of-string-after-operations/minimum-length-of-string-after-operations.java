class Solution {
    public int minimumLength(String s) {
        int ct[]=new int[26];
        int ans=0;
        for(char c:s.toCharArray()){
            ct[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ct[i]>0 && ct[i]%2==0) ans+=2;
            else if(ct[i]>0 && ct[i]%2==1) ans+=1;
        }
        return ans;
    }
}