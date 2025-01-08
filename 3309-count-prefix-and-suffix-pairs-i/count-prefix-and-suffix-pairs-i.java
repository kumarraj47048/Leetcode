class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ct=0;
        int n=words.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(check(words[i],words[j])) ct++;
            }
        }
        return ct;
    }
    public boolean check(String a, String b){
        if(a.length()>b.length()) return false;
        int l=0;
        while(l<a.length()){
            if(a.charAt(l)!=b.charAt(l)) return false;
            l++;
        }
        int idx=b.length()-a.length();
        
        l=0;
        while(idx<b.length()){
            if(a.charAt(l)!=b.charAt(idx)) return false;
            idx++;
            l++;
        }
        return true;
    }
    
}