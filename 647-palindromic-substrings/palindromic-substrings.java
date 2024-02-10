class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        char ch[]=new char[n];
        ch=s.toCharArray();
        int ct=0;
        for(int sz=1;sz<=n;sz++){
             int left=0;
             int right=left+sz-1;
             while(right<n){
                 if(checkPalindrome(ch,left,right)) ct++;
                 right++;
                 left++;
             }
        }
        return ct;
    }
    public static boolean checkPalindrome(char ch[],int l, int r){
        while(l<r){
            if(ch[l]!=ch[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}